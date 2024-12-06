//Program to transfer the amount from one account to another account

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Transaction {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		Scanner sc = new Scanner(System.in);
		try {
			
			//Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//Establishing the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
			System.out.println("Connection Established");
			
			//Creating the statement medium
			String sql1 = "update kodbank set Balance=Balance-? where Acc_no=?";
			String sql2 = "update kodbank set Balance=Balance+? where Acc_no=?";
			pstm1 = con.prepareStatement(sql1);
			pstm2 = con.prepareStatement(sql2);
			System.out.println("Statement Prepared");
			
			System.out.println("Enter the From account and To account and Amount to be transfered");
			int facc = sc.nextInt();
			int tacc = sc.nextInt();
			int amt = sc.nextInt();
			
			pstm1.setInt(1, amt);
			pstm1.setInt(2, facc);
			pstm2.setInt(1, amt);
			pstm2.setInt(2, tacc);
			con.setAutoCommit(false);
			
			
			//Execute Query
			int res1 = pstm1.executeUpdate();
			int res2 = pstm2.executeUpdate();
			con.commit();
			System.out.println("QUERY EXECUTED");
			
			
			//Displaying Result
			System.out.println(res1+" "+res2);
			
		}
		catch(Exception e) {
			try {
			System.out.println("SOME ERROR OCCURED DON'T WORRY, THE AMOUNT IS SAFE");
			con.rollback();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		finally {
			try {
				con.close();
				pstm1.close();
				pstm2.close();
				sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
