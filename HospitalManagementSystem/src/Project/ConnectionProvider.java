package Project;
import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_details", "root", "password");
			return con;
	}
}
