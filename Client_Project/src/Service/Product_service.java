package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class Product_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<Product> querySearch(String nameProduct){
		List<Product> list=new ArrayList<>();
		String sql = "Select * from product where productname like N'%" + nameProduct +"%'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
		} catch (Exception e) {
			
		}
		return list;
	}
	public int kqSearch(String nameProduct) {
		int count = 0;
		String sql = "select count(productname) as kq from product where productname like N'%" + nameProduct +"%'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			
		}
		return count;
	}
}
