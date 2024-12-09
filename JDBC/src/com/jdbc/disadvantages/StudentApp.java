package com.jdbc.disadvantages;


//The Major Disadvantage is we cannot transfer more number of object, so for the efficient way we go for Hibernate
//And Loading Driver and Establishing connections will taken by the hibernate so it is efficient way to use
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt =null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, Name, age, marks, gender");
		Student stu = new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
		try {
			//Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establishing the connection
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24?user=root&password=sanjith");

            //Creating the statement medium
            String sql = "insert into student value(?,?,?,?,?)"; 
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, stu.id);
            pstmt.setString(2, stu.name);
            pstmt.setInt(3, stu.age);
            pstmt.setInt(4, stu.marks);
            pstmt.setString(5, stu.gender);
            
            int nora = pstmt.executeUpdate();
            System.out.println(nora+" Rows Affected");
            
		}
      catch(Exception e) {
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
