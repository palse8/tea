import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	private static final String URL = "jdbc:mysql://localhost/sneakers";
	private static final String USER = "user01";
	private static final String PW = "password";
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,USER,PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
