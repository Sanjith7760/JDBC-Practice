//Program to Read or Query the data from the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//We are Reading the data of tables present in the june24 database 
public class ReadOperation {

	/*
	public static void main(String[] args) {
		try {
			// Loading The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Establishing the Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
			System.out.println("Connection Established");
			
			//Creating the statement Medium
			Statement statement = connection.createStatement();
			System.out.println("Statement Medium is Created");
			
			//Execute Query
			//String sql = "select marks from batches where id=1";
			//String sql = "select id from batches where marks=77";
//			String sql = "select * from batches ";
			String sql = "select * from batches where id=3";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Query executed and got the resultSet from the database and stored in the rs");
			
			//Displaying the result
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3));
			}
			System.out.println("Result Displayed");
			
			
			//Closing the Resources
			connection.close();
			statement.close();
			rs.close();
			System.out.println("Resources Closed");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} */
	
	
	
	
	
	//Same procedure but we will do it by taking input from user, in these instead of createStatement we use preparedStatement
	public static void main(String[] args) {
		
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc=new Scanner(System.in);
		
		try {
			
			// Loading The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Establishing the Connection
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
			System.out.println("Connection Established");
			
			//Creating the statement Medium
			//Execute Query
			//String sql = "select marks from batches where id=1";
			//String sql = "select id from batches where marks=77";
//			String sql = "select * from batches ";
			String sql = "select * from batches where id = ?";
			 ps = connection.prepareStatement(sql);
			System.out.println("Enter Id of batches");
			int id = sc.nextInt();
			ps.setInt(1, id);
			System.out.println("Statement Medium is Created");
			
			 rs = ps.executeQuery();
			System.out.println("Query executed and got the resultSet from the database and stored in the rs");
			
			//Displaying the result
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3));
			}
			System.out.println("Result Displayed");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//Closing the Resources
				connection.close();
				ps.close();
				rs.close();
				sc.close();
				System.out.println("Resources Closed");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 
	

}
