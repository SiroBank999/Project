package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String DATABASE_LINK = "jdbc:sqlserver://localhost:1433;databaseName=csdl_banhang";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "2912";

	public static Connection Connect() {
		/*
		 * Connection conn =null; try { conn =
		 * DriverManager.getConnection(DATABASE_LINK,USER_NAME,PASSWORD); if(conn !=
		 * null) { System.out.print("Kết nối thành công"); } }catch (Exception e) {
		 * System.out.print("Không thể kết nối "); e.printStackTrace(); } return conn;
		 */
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String user = "sa";
			String pass = "2912";
			String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=csdl_banhang";
			connection = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

		return connection;

	}
}
