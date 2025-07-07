from flask import Flask, request, render_template, redirect, url_for
import os
import csv
import xml.etree.ElementTree as ET
import re

app = Flask(__name__)

XML_FILE = 'players_data.xml'
FETCHED_FILE = 'fetched_data.xml'

# Create XML file if it doesn't exist
if not os.path.exists(XML_FILE):
    with open(XML_FILE, 'w') as f:
        f.write('<data>\n</data>')


@app.route('/', methods=['GET'])
def form():
    prefill = None
    error = request.args.get('error')

    if request.args.get('prefill') == 'true':
        try:
            tree = ET.parse(FETCHED_FILE)
            entry = tree.getroot().find('entry')
            if entry is not None:
                prefill = {
                    'name': entry.findtext('name'),
                    'phone': entry.findtext('phone'),
                    'email': entry.findtext('email'),
                    'unqid': entry.attrib.get('id'),
                    'gender': entry.findtext('gender'),
                    'date': entry.findtext('dob'),
                    'nationality': entry.findtext('nationality')
                }
        except:
            error = "No fetched data available."

    return render_template('infopage.html', prefill=prefill, error=error)


@app.route('/submit', methods=['POST'])
def submit():
    action = request.form.get('action')

    if action == 'fetch':
        fetch_unqid = request.form.get('fetch_unqid')

        if not fetch_unqid:
            return redirect('/?error=Please+enter+a+Unique+ID+before+fetching.')

        try:
            tree = ET.parse(XML_FILE)
            root = tree.getroot()

            for entry in root.findall('entry'):
                if entry.attrib.get('id') == fetch_unqid:
                    fetched_root = ET.Element('data')
                    fetched_root.append(entry)
                    ET.ElementTree(fetched_root).write(FETCHED_FILE, encoding='utf-8', xml_declaration=True)
                    return redirect('/?prefill=true')

            return redirect('/?error=Entry+with+that+Unique+ID+not+found.')

        except Exception as e:
            return redirect(f'/?error=Fetch+Error:+{str(e)}')

    else:
        # Normal form submission
        name = request.form.get('name')
        phone = request.form.get('phone')
        email = request.form.get('email')
        unqid = request.form.get('unqid')
        gender = request.form.get('gender')
        dob = request.form.get('date')
        nationality = request.form.get('nationality')

        with open(XML_FILE, 'r') as file:
            content = file.read()

        if f'id="{unqid}"' in content:
            prefill = {
                'name': name,
                'phone': phone,
                'email': email,
                'unqid': unqid,
                'gender': gender,
                'date': dob,
                'nationality': nationality
            }
            return render_template('infopage.html', prefill=prefill, error="Unique ID already exists. Try a new ID.")

        # Add new entry to XML
        xml_entry = f"""
            <entry id="{unqid}">
                <name>{name}</name>
                <phone>{phone}</phone>
                <email>{email}</email>
                <gender>{gender}</gender>
                <dob>{dob}</dob>
                <nationality>{nationality}</nationality>
            </entry>"""

        content = content.replace('</data>', xml_entry + '\n</data>')

        with open(XML_FILE, 'w') as file:
            file.write(content)

        return redirect('/')


@app.route('/import', methods=['POST'])
def import_data():
    try:
        file = request.files.get('import_file')
        if not file or file.filename == '':
            return redirect(url_for("form", error="No file selected."))

        ordered_fields = ["name", "phone", "email", "gender", "dob", "nationality"]
        required_fields = {"name", "phone", "email", "unique_id"}

        # Load existing XML
        if os.path.exists(XML_FILE):
            tree = ET.parse(XML_FILE)
            root = tree.getroot()
        else:
            root = ET.Element('data')
            tree = ET.ElementTree(root)

        # Track existing entries to avoid duplicates
        existing_entries = set()
        for entry in root.findall("entry"):
            data = {child.tag: (child.text or "").strip() for child in entry}
            data["unique_id"] = entry.attrib.get("id", "").strip()
            signature = frozenset((k, v) for k, v in data.items())
            existing_entries.add(signature)

        entries_added = 0

        # ✅ FIX: Clean and read CSV lines
        csv_text = file.stream.read().decode("utf-8")
        csv_lines = [line for line in csv_text.splitlines() if line.strip()]  # remove blank lines
        reader = csv.DictReader(csv_lines)

        headers = set(reader.fieldnames or [])
        present_fields = [field for field in ordered_fields if field in headers]

        for row in reader:
            if not all(row.get(field) for field in required_fields):
                continue

            phone = row.get("phone", "").strip()
            if not re.fullmatch(r"[0-9]{10}", phone):
                continue

            row_data = {k: (row.get(k, "").strip()) for k in present_fields}
            row_data["unique_id"] = row.get("unique_id", "").strip()
            signature = frozenset((k, v) for k, v in row_data.items())

            if signature in existing_entries:
                continue

            entry = ET.SubElement(root, "entry", id=row_data["unique_id"])
            for field in present_fields:
                ET.SubElement(entry, field).text = row_data.get(field, "")
            entries_added += 1

        if entries_added == 0:
            return redirect(url_for("form", error="All entries in the CSV are already present in the XML!"))

        tree.write(XML_FILE, encoding="utf-8", xml_declaration=True)
        return redirect("/")

    except Exception as e:
        return redirect(url_for("form", error=f"Import Error: {str(e)}"))


if __name__ == '__main__':
    app.run(debug=True)
