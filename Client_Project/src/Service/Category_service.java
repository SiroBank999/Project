package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Category;

public class Category_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Category> getListCategory() {
		List<Category> list = new ArrayList<>();
		String query = "select * from category";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	

}
