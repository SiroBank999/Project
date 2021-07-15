package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Contact;

public class Contact_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<Contact> getContact(){
		List<Contact> list = new ArrayList<>();
		String query = "SELECT * FROM contact";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Contact(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
		
	}
	public void updatesContact(String status, int id) {
		String query = "UPDATE contact SET status=? WHERE id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, id);
			
			ps.execute();

		} catch (Exception e) {

		}
		
}
}

