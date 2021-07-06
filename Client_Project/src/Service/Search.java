package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class Search {
	Connection conn = null;

	public List<Product> querySearch(String nameProduct) throws SQLException {
		new Database();
		conn = Database.Connect();
		String sql = "Select * from product where productname like N'%" + nameProduct +"%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		List<Product> list=new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Product pr = new Product();
			pr.setProductName(rs.getString("productname"));
			pr.setPrice(rs.getInt("price"));
			pr.setSale(rs.getInt("sale"));
			pr.setImg(rs.getString("image"));
			pr.setDescribe(rs.getString("describe"));
			pr.setFabric(rs.getString("fabric"));
			pr.setId(rs.getInt("id"));
			
			list.add(pr);
		}
		return list;
	}
	public int kqSearch(String nameProduct) throws SQLException {
		new Database();
		conn = Database.Connect();
		String sql = "select count(productname) as kq from product where productname like N'%" + nameProduct +"%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		return count;

	}
}
