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
	public List<Product> getProductsale() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product where sale is not null ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),
						rs.getDate(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list ;
	}
	public List<Product> getProductnew() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product  ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),
						rs.getDate(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list ;
	}
	
}
