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
	public Product getProductById(int id) {
		Product pd = new Product();
		String query = "select * from product where id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pd.setId(rs.getInt(1));
				pd.setProductname(rs.getString(2));
				pd.setPrice(rs.getInt(3));
				pd.setSale(rs.getInt(4));
				pd.setImage(rs.getString(5));
				pd.setDate(rs.getDate(6));
				pd.setDescribe(rs.getString(7));
				pd.setId_category(rs.getInt(8));
				pd.setFabric(rs.getString(9));
				pd.setStatus(rs.getString(10));
	
			}
		} catch (Exception e) {
		}
		return pd ;
	}
	public List<Product> getProductnew() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product  ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt(1));
				pr.setProductname(rs.getString(2));
				pr.setPrice(rs.getInt(3));
				pr.setSale(rs.getInt(4));
				pr.setImage(rs.getString(5));
				pr.setDate(rs.getDate(6));
				pr.setDescribe(rs.getString(7));
				pr.setId_category(rs.getInt(8));
				pr.setFabric(rs.getString(9));
				pr.setStatus(rs.getString(10));
				list.add(pr);
			}
		} catch (Exception e) {
		}
		return list ;
	}
	public List<Product> getProductByIdCate(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product where id_category =? ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt(1));
				pr.setProductname(rs.getString(2));
				pr.setPrice(rs.getInt(3));
				pr.setSale(rs.getInt(4));
				pr.setImage(rs.getString(5));
				pr.setDate(rs.getDate(6));
				pr.setDescribe(rs.getString(7));
				pr.setId_category(rs.getInt(8));
				pr.setFabric(rs.getString(9));
				pr.setStatus(rs.getString(10));
				list.add(pr);
			}
		} catch (Exception e) {
		}
		return list ;
	}
	public List<Product> getProductsale() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product where sale is not null ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt(1));
				pr.setProductname(rs.getString(2));
				pr.setPrice(rs.getInt(3));
				pr.setSale(rs.getInt(4));
				pr.setImage(rs.getString(5));
				pr.setDate(rs.getDate(6));
				pr.setDescribe(rs.getString(7));
				pr.setId_category(rs.getInt(8));
				pr.setFabric(rs.getString(9));
				pr.setStatus(rs.getString(10));
				list.add(pr);
			}
		} catch (Exception e) {
		}
		return list ;
	}
	public List<Product> querySearch(String nameProduct){
		List<Product> list=new ArrayList<>();
		String sql = "Select * from product where productname like N'%" + nameProduct +"%'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setId(rs.getInt(1));
				pr.setProductname(rs.getString(2));
				pr.setPrice(rs.getInt(3));
				pr.setSale(rs.getInt(4));
				pr.setImage(rs.getString(5));
				pr.setDate(rs.getDate(6));
				pr.setDescribe(rs.getString(7));
				pr.setId_category(rs.getInt(8));
				pr.setFabric(rs.getString(9));
				pr.setStatus(rs.getString(10));
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
	public static void main(String[] agrs) {
		Product_service p = new Product_service();
		Product pd =p.getProductById(3);
		System.out.print(pd.toString());
		
	}
}
