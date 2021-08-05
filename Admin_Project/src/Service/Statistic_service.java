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
		String sql="select Year([date]) as [date], SUM([into]) as [into] from [order] where status=N'Hoàn thành' group by Year([date]) order by Year([date]) desc";
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
	public List<Statistic> getRevenueProduct(){
		List<Statistic> list=new ArrayList<>();
		String sql="select product.productname as [productname],price as [price],sum(amount) as [amount],sum(price*amount) as [tong] from order_detail,product,[order] \r\n"
				+ "where order_detail.id_product=product.id and order_detail.id_order=[order].id and [order].[status]=N'Hoàn thành' \r\n"
				+ "group by product.productname,price order by sum(amount) desc";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Statistic revenue=new Statistic();
				revenue.setNameproduct(rs.getString("productname"));
				revenue.setPrice(rs.getDouble("price"));
				revenue.setAmount(rs.getInt("amount"));
				revenue.setTotals(rs.getDouble("tong"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
		
	}
	public List<Statistic> top5Sales(){
		List<Statistic> list=new ArrayList<>();
		String sql="select top 5 product.productname as [productname], sum(amount) as [amount] from order_detail,product,[order] \r\n"
				+ "where order_detail.id_product=product.id and [order].id=order_detail.id_order and month([date])=month(getDate()) and year([date])=year(getDate()) and [order].status=N'Hoàn thành'\r\n"
				+ "group by product.productname order by sum(amount) desc";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Statistic revenue=new Statistic();
				revenue.setNameproduct(rs.getString("productname"));
				revenue.setAmount(rs.getInt("amount"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
		
	}
	public List<Statistic> totalCate(){
		List<Statistic> list=new ArrayList<>();
		String sql="select categoryname as [productname],sum(price*amount) as [amount] from order_detail,category,product,[order] \r\n"
				+ "where order_detail.id_product=product.id and [order].id=order_detail.id_order and product.id_category=category.id\r\n"
				+ "and month([date])=month(getDate()) and [order].status=N'Hoàn thành' group by categoryname";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Statistic revenue=new Statistic();
				revenue.setNameproduct(rs.getString("productname"));
				revenue.setAmount(rs.getInt("amount"));
				
				list.add(revenue);
			}
		} catch (Exception e) {

		}
		return list;
		
	}
}
