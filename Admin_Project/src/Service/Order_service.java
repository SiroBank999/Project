package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Order;

public class Order_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public int getTotalOrderNew() {
		String query = "select count(*) from [order]";
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

	public List<Order> pagingOrderNew(int index) {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order]  order by date desc offset ? rows fetch next 6 rows only";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> OrderNew() {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order] where status=N'Đơn mới'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> OrderProcessing() {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order] where status=N'Đang xử lí'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> OrderFinish() {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order] where status=N'Hoàn thành'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> OrderDestroy() {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order] where status=N'Đã hủy'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> SearchOrder(String donhang) {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[status],[into] from [order] where id like '"+donhang+"' or fullname like N'%"+donhang+"%' or phone like '"+donhang+"'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order od=new Order();
				od.setId(rs.getString("id"));
				od.setFullname(rs.getString("fullname"));
				od.setPhone(rs.getString("phone"));
				od.setAddress(rs.getString("address"));
				od.setDate(rs.getDate("date"));
				od.setStatus(rs.getString("status"));
				od.setInto(rs.getDouble("into"));
				
				list.add(od);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public int getTotalOrderAdmin() {
		int sum = 0;
		String sql = "select sum([into]) from [order] where status=N'Hoàn thành' and month([date])=MONTH(getDate())";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return sum;
	}
	public int getCustomer() {
		int count = 0;
		String sql = "select count(distinct id_user) from [order]";
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
	public int getOrder() {
		int count = 0;
		String sql = "select count(id) from [order] where status=N'Đơn mới'";
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
	public int getUserNew() {
		int count = 0;
		String sql = "	select count(id) from [user] where id not in(select id_user from [order],[user]) \r\n"
				+ "";
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
