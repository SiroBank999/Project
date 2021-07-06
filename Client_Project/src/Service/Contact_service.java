package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Service.Database;
import Model.Contact;

public class Contact_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Contact> getContact(){
		List<Contact> list = new ArrayList<>();
		String query = "select * from contact";
				try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Contact(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (Exception e) {
		}
		return list;
		
	}
	
	public void insertContact(String name,String phone, String email,String content) {
		String query = "insert into contact(name,phone,email,content) values(?,?,?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, content);
			
			ps.executeUpdate();
		} catch (Exception e) {
			
			
		}
		
}
}
