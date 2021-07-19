
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
	public User CheckUsername(String username) {
		String sql="select * from [user] where username=?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6), rs.getString(7)
						);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public  void insertAcc(User register) {
		String query = "INSERT INTO [user](fullname,username,password,phone,email) values(?,?,?,?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, register.getFullname());
			ps.setString(2, register.getUsername());
			ps.setString(3, register.getPassword());
			ps.setString(4, register.getPhone());
			ps.setString(5, register.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	public void updateUser(String fullname, String phone ,String email,String password,int id) {
		String query ="UPDATE [user] SET fullname=?, phone=?,email=?, password=? WHERE id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		User_service m = new User_service();
	User n = m.CheckUser("", "");
		System.out.print(n);

	}
	
}