
package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Model.User;

public class User_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public User CheckUser(String username, String password) {

		String query = "select * from [user] where username=? and password=?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6), rs.getString(7)
						);

			}
		} catch (Exception e) {

		}
		return null;

	}
	public void insertAcc(String fullname,String username ,String password,String phone , String email,String status) {
		String query = "INSERT INTO [user](fullname,username,password,phone,email,status) values(?,?,?,?,?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, status);
			ps.executeUpdate();
		} catch (Exception e) {
			
			
		}
		
	}
	public static void main(String[] args) {
		User_service m = new User_service();
	User n = m.CheckUser("", "");
		System.out.print(n);

	}
	
}