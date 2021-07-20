package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Order;
import Model.Statistic;

public class Statistic_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Statistic> getRevenueMonth(){
		List<Statistic> list=new ArrayList<>();
		String sql="select  MONTH([date]) as [date], SUM([into]) as [into] from [order] where year([date])=year(getDate()) and status=N'Hoàn thành' group by MONTH([date])";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Statistic revenue=new Statistic();
				revenue.setMonth(rs.getString("date"));
				revenue.setTotals(rs.getDouble("into"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
		
	}
	public List<Statistic> getStatisticYear(){
		List<Statistic> list=new ArrayList<>();
		String sql="select Year([date]) as [date], SUM([into]) as [into] from [order] where status=N'Hoàn thành' group by Year([date])";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Statistic rv=new Statistic();
				rv.setYear(rs.getInt("date"));
				rv.setTotals(rs.getDouble("into"));
				
				list.add(rv);
			}
		} catch (Exception e) {

		}
		return list;
		
	}
	public int getTotalOrder() {
		String query = "select count(*) from [order] where status=N'Hoàn thành'";
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

	public List<Order> pagingOrder(int index) {
		List<Order> list = new ArrayList<>();
		String query = "select id,fullname,phone,address,date,[into] from [order] where status=N'Hoàn thành' order by date desc offset ? rows fetch next 8 rows only";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order revenue=new Order();
				revenue.setId(rs.getString("id"));
				revenue.setFullname(rs.getString("fullname"));
				revenue.setPhone(rs.getString("phone"));
				revenue.setAddress(rs.getString("address"));
				revenue.setDate(rs.getDate("date"));
				revenue.setInto(rs.getDouble("into"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<Order> querySearch(String dayStart, String dayEnd) {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT * FROM [order] WHERE status=N'Hoàn thành' and [date] BETWEEN '"+dayStart+"' AND '"+dayEnd+"'";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order revenue=new Order();
				revenue.setId(rs.getString("id"));
				revenue.setFullname(rs.getString("fullname"));
				revenue.setPhone(rs.getString("phone"));
				revenue.setAddress(rs.getString("address"));
				revenue.setDate(rs.getDate("date"));
				revenue.setInto(rs.getDouble("into"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
	}
	
}
