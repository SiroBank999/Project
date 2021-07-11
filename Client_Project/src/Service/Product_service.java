package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.Product;
import Model.Size;

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

	public List<Product> getProductnew() {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product order by datesub desc";
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
		return list;
	}

	public List<Product> getProductByIdCate(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select top 4 * from product where id_category =?";
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
		return list;
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
		return list;
	}

	public List<Product> querySearch(String nameProduct) {
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where productname like N'%" + nameProduct + "%'";
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
		String sql = "select count(productname) as kq from product where productname like N'%" + nameProduct + "%'";
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

	public List<Product> product_sale(int indexpage) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where sale is not null order by id \r\n"
				+ "				offset ? rows fetch next 12 rows only;";
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

	public int Countproduct_sale() {
		String sql = "select count(*) from product where sale is not null";
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

	public List<Product> product_new() {
		List<Product> list = new ArrayList<>();
		String query = "select top 20 * from product order by datesub desc";
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
		return list;
	}
	

	public List<Product> product(int indexpage) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product order by id\r\n"
				+ "		offset ? rows fetch next 12 rows only;";
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
		String sql = "select count(*) from product ";
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
	
	public List<Product> getproductbycategory(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product inner join category on "
				+ "product.id_category = category.id where [category].[id]=?";
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
		return list;
	}
	public List<Product> product_sale_desc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null order by sale desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_asc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null order by sale asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_new() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null order by datesub desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_old() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null order by datesub asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_nameAsc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null order by productname asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_nameDesc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW' and sale is not null order by productname desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_desc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW'  order by sale desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_asc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW' order by sale,price asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
	public List<Product> product_new_old() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW' order by datesub asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_nameAsc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW' order by productname asc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_nameDesc() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top 20 * from product where status='NEW' order by productname desc";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_filter() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null and sale BETWEEN 0 AND 199000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_filter1() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null and sale BETWEEN 200000 AND 399000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_filter2() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null and sale BETWEEN 400000 AND 800000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_sale_filter3() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and sale is not null and sale>800000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_filter() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and price BETWEEN 0 and 199000 or sale BETWEEN 0 AND 199000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_filter1() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and (price is not null and sale BETWEEN 200000 AND 399000) or (price is null and sale BETWEEN 200000 AND 399000)";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_filter2() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and (price is not null and sale BETWEEN 400000 AND 800000) or (price is null and sale BETWEEN 400000 AND 800000)";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<Product> product_new_filter3() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where status='NEW' and price>800000 or sale>800000";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
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



	public static void main(String[] agrs) {
		Product_service p = new Product_service();
		Product pd = p.getProductById(3);
		System.out.print(pd.toString());

	}
}
