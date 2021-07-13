package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Object.Order;
public class OrderModel {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertOrder(String fullname,String phone,String email,String address,String status,double into ) {
		String query ="INSERT INTO order(fullname,phone,email,address,status,into) VALUES(?,?,?,?,?,?)";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, status);
			ps.setDouble(6,into);
			ps.execute();
			
		} catch (Exception e) {
			
		}
	}
	public List<Order> getListOrder(){
		List<Order> list = new ArrayList<>();
		String query ="SELECT * FROM order";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(5),rs.getDouble(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

}
