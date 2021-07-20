package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.Order;
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
		return pd;
	}

	public List<Product> Allproduct(int indexpage) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product order by id desc offset ? rows fetch next 12 rows only;";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (indexpage - 1) * 12);
			ResultSet rs = ps.executeQuery();
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int Countproduct() {
		String sql = "select count(*) from product";
		try {
			conn = Database.Connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public void insertProduct(String productname, int price, int sale, String image, String describe, int id_cate,
			String fabric, String status) {

		String query = "INSERT INTO product (productname, price, sale, image, datesub, describe, id_category, fabric, status) values(?,?,?,?,GETDATE(),?,?,?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, productname);
			ps.setInt(2, price);
			ps.setInt(3, sale);
			ps.setString(4, image);
			ps.setString(5, describe);
			ps.setInt(6, id_cate);
			ps.setString(7, fabric);
			ps.setString(8, status);
			ps.execute();

		} catch (Exception e) {

		}

	}

	public void deleteProductbyId(int id) {
		String query = "DELETE FROM product where id=?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();

		} catch (Exception e) {
		}
	}

	public void updateProduct(String productname, int price, int sale, String image, String datesub, String describe,
			int id_cate, String fabric, String status, int id) {
		String query = "UPDATE product SET productname=?,price=?, sale=?,image=?, datesub =? ,describe=?,id_category=?,fabric=?,status=? WHERE id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, productname);
			ps.setInt(2, price);
			ps.setInt(3, sale);
			ps.setString(4, image);
			ps.setString(5, datesub);
			ps.setString(6, describe);
			ps.setInt(7, id_cate);
			ps.setString(8, fabric);
			ps.setString(9, status);
			ps.setInt(10, id);
			ps.execute();

		} catch (Exception e) {

		}

	}

	public List<Product> Searchproduct(String tensanpham) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product where productname like ?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + tensanpham + "%");
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

}
