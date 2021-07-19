package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public void addCategory(String categoryname, String image) {

		String query = "insert into category(categoryname,image) values(?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, categoryname);
			ps.setString(2, image);
			ps.execute();

		} catch (Exception e) {
		}

	}

	public int getTotalCategory() {
		String query = "select count(*) from category";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}

		return 0;
	}

	public List<Category> pagingCategory(int index) {
		List<Category> list = new ArrayList<>();
		String query = "select * from category order by id offset ? rows fetch next 7 rows only;";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 7);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public void deleteCategorybyId(int id) {
		String query = "DELETE FROM category where id=?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();

		} catch (Exception e) {
		}
	}

	public Category getCateById(int id) {
		Category pd = new Category();
		String query = "select * from category where id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pd.setId(rs.getInt(1));
				pd.setCategoryname(rs.getString(2));
				pd.setImg(rs.getString(3));
			}
		} catch (Exception e) {
		}
		return pd;
	}

	public void updateCategory(String categoryname, String img, int id) {
		String query = "UPDATE category SET categoryname = ?,image=? WHERE id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, categoryname);
			ps.setString(2, img);
			ps.setInt(3, id);
			ps.executeQuery();

		} catch (Exception e) {

		}
	}

	public List<Category> category_new_nameAsc() {
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category order by categoryname asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category pr = new Category();
				pr.setId(rs.getInt(1));
				pr.setCategoryname(rs.getString(2));
				pr.setImg(rs.getString(3));
				list.add(pr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Category> category_new_nameDesc() {
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category order by categoryname desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category pr = new Category();
				pr.setId(rs.getInt(1));
				pr.setCategoryname(rs.getString(2));
				pr.setImg(rs.getString(3));
				list.add(pr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] agrs) {
		Category_service n = new Category_service();
		n.updateCategory("a", "b", 10);
		System.out.println("thanh cong");
	}

}
