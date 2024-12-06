//Program to Insert the data into database and in this we use executeUpdate because of DML command and we store it in nora which is of int type, we dont use the result set in this

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class CreateOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt =null;
		Scanner sc = new Scanner(System.in);
		try {
			//Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//Establishing the connection
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24?user=root&password=sanjith");
            System.out.println("Connection established");

            //Creating the statement medium
            String sql = "insert into Student value(?,?,?)"; 
            pstmt = con.prepareStatement(sql);
            System.out.println("Statement medium prepared");
            System.out.println("Enter Student id, name and section");
            int id = sc.nextInt();
            String name = sc.next();
            String sec = sc.next();
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, sec);
            
            
            //Execute Query
            int nora = pstmt.executeUpdate();
            System.out.println("QUERY EXECUTED");
            
            //Displaying the result
            System.out.println(nora+" Rows Affected");
            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			con.close();
			pstmt.close();
			sc.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
