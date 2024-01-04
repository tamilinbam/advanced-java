package jdbc;
import java.sql.*;
import java.util.Scanner;
public class jbprogram1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		 String url="jdbc:mysql://localhost:3306/kode";
		 String username="root";
		 String password="root";
		try {
		 Connection con =DriverManager.getConnection(url,username,password);
		System.out.println("statement is ready !!!!!!");
		System.out.println("successs");
		System.out.println("choose the option 1 ,2,3"	);
		System.out.println("enter 1 to insert ");
		System.out.println("enter 2 to update ");
		System.out.println("enter 3 to delete ");
		System.out.println("enter 4 to fetchData ");
		int a = scan.nextInt();
		switch (a) {
			case 1:{
				insert (con);break;
			}
			case 2:{
				update(con); break;
			}
			case 3:{
				delete(con);break;
			}
			case 4:{
				fetchData(con); break;
			}
			default:{
				System.out.println("thank you");
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void insert(Connection con)throws Exception
	{
		Scanner scan=new Scanner(System.in);
		String query=" insert into student(?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		System.out.println("enter the rollno");
		int roll= scan.nextInt();
		System.out.println("enter the name");
		String name = scan.next();
		pstmt.setInt(1,roll);
		pstmt.setString(2,name);
		pstmt.execute();
		System.out.println("rows are inserted");
	}
	public static void update (Connection con)throws Exception {
		Scanner scan=new Scanner(System.in);
		String query=" insert into student(?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		System.out.println("enter the rollno");
		int roll= scan.nextInt();
		System.out.println("enter the name");
		String name = scan.next();
		pstmt.setInt(1,roll);
		pstmt.setString(2,name);
		pstmt.execute();
		System.out.println("rows are inserted");
	}
	public static void delete (Connection con)throws Exception {
		Scanner scan=new Scanner(System.in);
		String query=" insert into student(?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		System.out.println("enter the rollno");
		int roll= scan.nextInt();
		System.out.println("enter the name");
		String name = scan.next();
		pstmt.setInt(1,roll);
		pstmt.setString(2,name);
		pstmt.execute();
		System.out.println("rows are inserted");
	}
	public static void fetchData(Connection con)throws Exception {
		Scanner scan=new Scanner(System.in);
		String query=" insert into student(?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		System.out.println("enter the rollno");
		int roll= scan.nextInt();
		System.out.println("enter the name");
		String name = scan.next();
		pstmt.setInt(1,roll);
		pstmt.setString(2,name);
		pstmt.execute();
		System.out.println("rows are inserted");
	}

}
