package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jjdd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "root";
        String query = "insert into patient(p_id, p_name, p_age) values (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);

            System.out.println("enter the length of the data ");
            int a = scan.nextInt();

            for (int i = 0; i < a; i++) {
                System.out.println("enter the patient id");
                int id = scan.nextInt();
                System.out.println("enter the patient name");
                String name = scan.next();
                System.out.println("enter the patient age");
                int age = scan.nextInt();

                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setInt(3, age);

                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
