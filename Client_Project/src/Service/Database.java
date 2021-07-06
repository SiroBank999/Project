package Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static String DATABASE_LINK ="jdbc:sqlserver://localhost:1433;databaseName=csdl_banhang";
	private static String USER_NAME = "sa";
    private static String PASSWORD = "123456";
    public static Connection Connect() {
    	Connection conn = null;
    	
    	try {
    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		 conn = DriverManager.getConnection(DATABASE_LINK,USER_NAME,PASSWORD);
			if(conn != null) {
				System.out.print("Kết nối thành công");
			}
		}catch (Exception e) {
			System.out.print("Không thể kết nối ");
			e.printStackTrace();
		}
    	return conn;
    }
    public static void main(String[] args) {
    	Database.Connect();
	}

}
