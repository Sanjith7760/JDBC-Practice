import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateOperation {

	public static void main(String[] args) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
		//Loading the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		//Establishing Connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june24?user=root&password=sanjith");
		System.out.println("Connection Established");
		
		//Creating statement medium
		String sql = "update result set m3=? where id=?";
		pstmt = con.prepareStatement(sql);
		
		System.out.println("Enter the new name to be updated along with the id");
		int marks=sc.nextInt();
		int id=sc.nextInt();
		
		pstmt.setInt(1, marks);
		pstmt.setInt(2, id);
		
		int nora = pstmt.executeUpdate();
		System.out.println(nora +" ROWS AFFECTED  ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			con.close();
			sc.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
