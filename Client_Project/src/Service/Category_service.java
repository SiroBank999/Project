package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Category;
import Model.Product;

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
	
	public Category getnamebycategory(int id) {
		Category pd = new Category();
		String query = "select * from category where id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pd.setId(rs.getInt("id"));
				pd.setCategoryname(rs.getString("categoryname"));
				pd.setImg(rs.getString("image"));
			}
		} catch (Exception e) {
		}
		return pd;
	}
	
	
	

}
