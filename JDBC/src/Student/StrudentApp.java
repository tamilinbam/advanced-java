package Student;
import java.sql.*;
import java.util.Scanner;
public class StrudentApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		String url="jdbc:mysql://localhost:3306/kode";
		 String username="root";
		 String password="root";
		 String query = "insert into student value(?,?,?) ";

		 try {
			Student student1 = new Student(1, "tamil",99);
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, student1.roll_no);
                pstmt.setString(2, student1.name);
                pstmt.setInt(3, student1.mark);
                pstmt.executeUpdate();
            Student student2 = new Student(2, "veena", 66);
            pstmt.setInt(1, student2.roll_no);
            pstmt.setString(2, student2.name);
            pstmt.setInt(3, student2.mark);
            pstmt.executeUpdate();
            Student student3 = new Student(3, "dinesh", 33);
            pstmt.setInt(1, student3.roll_no);
            pstmt.setString(2, student3.name);
            pstmt.setInt(3, student3.mark);
            pstmt.executeUpdate();

			
			System.out.println("Data inserted successfully!");
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}
		 
	}

}
