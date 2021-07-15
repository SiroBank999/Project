package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Order_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertOrder(String fullname, String phone,String email,String address,int id_user,double into ) {
		String query ="INSERT INTO [order](fullname,phone,email,[address],id_user,[into]) VALUES(?,?,?,?,?,?)";
		try {
			conn =Database.Connect();
			ps =conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setInt(5, id_user);
			ps.setDouble(6, into);
			ps.executeUpdate();
			
		} catch (Exception e) {

		}
	}
	public static void main(String[] agrs) {
		Order_service order = new Order_service();
		order.insertOrder("Nguyễn Văn Nhơn","0333333","po@po","Tổ dân phố chầm",1,500000);
	}
}
