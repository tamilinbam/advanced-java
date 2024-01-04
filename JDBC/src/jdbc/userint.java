package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class userint {
	public static void main(String[] args) {
			Scanner scan = new Scanner (System.in);
		String url="jdbc:mysql://localhost:3306/kode";
		 String username="root";
		 String password="root";
		 String query = "insert into student values(?,?)";
		 try {
			Connection	con =DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt= con.prepareStatement(query);
			System.out.println("enter the rollno");
			int roll= scan.nextInt();
			System.out.println("enter the name");
			String name = scan.next();
			pstmt.setInt(1,roll);
			pstmt.setString(2,name);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
