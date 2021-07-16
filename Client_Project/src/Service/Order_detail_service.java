package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Order_detail_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertOrderDetail(int amount,String id_order,int id_product,int id_size) {
		String query ="INSERT INTO order_detail(amount,id_order,id_product,id_size) VALUES(?,?,?,?)";
		try {
			conn =Database.Connect();
			ps =conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, id_order);
			ps.setInt(3, id_product);
			ps.setInt(4, id_size);
			ps.executeUpdate();
			
		} catch (Exception e) {

		}
	}
	public static void main(String[] agrs) {
		
	}

}
