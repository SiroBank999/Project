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
	public List<Order> getListOrder(){
		List<Order> list = new ArrayList<Order>();
		String query = "SELECT * FROM [order]";
		try {
			conn =Database.Connect();
			ps =conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString(1));//Chú ý lấy cột ID
				list.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public void insertOrder(String fullname, String phone,String email,String address,int id_user,double into,String id ) {
		String query ="INSERT INTO [order](fullname,phone,email,[address],id_user,[into],id) VALUES(?,?,?,?,?,?,?)";
		try {
			conn =Database.Connect();
			ps =conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setInt(5, id_user);
			ps.setDouble(6, into);
			ps.setString(7, id);
			ps.executeUpdate();
			
		} catch (Exception e) {

		}
	}
	public static void main(String[] agrs) {
		
	
	}
}
