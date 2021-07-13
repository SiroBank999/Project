package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Object.User;

public class UserModel {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<User> getListUser(){
		List<User> list = new ArrayList<>();
		String query = "select * from user";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6), rs.getString(7)
						));
			}
		} catch (Exception e) {

		}
		return list;
	}
	public User CheckUser(String username, String password) {

		String query = "select * from user  where username=? and password=? and status='ENABLE'";
		try {
			conn = Database.ketNoi();
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
	public void updateUser_admin(String status,int id) {
		String query ="UPDATE user SET status=? WHERE id =?";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void updatePassUser(String pass,int id) {
		String query ="UPDATE user SET password=? WHERE id =?";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setString(1, pass);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void insertAcc(String fullname,String username ,String password,String phone , String email,String status) {
		String query = "INSERT INTO user(fullname,username,password,phone,email,status) values(?,?,?,?,?,?)";
		try {
			conn = Database.ketNoi();
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
		UserModel m = new UserModel();
		m.updateUser_admin("ENABLE", 1);

	}
	
	
}
