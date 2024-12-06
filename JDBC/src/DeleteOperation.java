//Program to delete the data in the Patient database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			//Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//Establishing the Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
			System.out.println("Connection Established");
			
			//Creating the statement medium
			String sql = "delete from patient where id=?";
			pstmt = con.prepareStatement(sql);
			System.out.println("Statement Prepared");
			System.out.println("Enter the Patient Id to delete the records");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			
			
			//Execute Query
			int nora = pstmt.executeUpdate();
			System.out.println("QUERY EXECUTED");
			
			//Display the result
			System.out.println(nora+ " Rows Affected");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
			con.close();
			pstmt.close();
			sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
