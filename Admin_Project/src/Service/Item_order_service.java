package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Model.Order_detail;
import Model.Product;

public class Item_order_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<Order_detail> getListItemOrder(String id_order){
		String query = "SELECT order_detail.id,order_detail.amount,order_detail.id_order,product.productname,size.[name] FROM order_detail,product,size WHERE order_detail.id_product = product.id AND order_detail.id_size = size.id AND id_order = ?";
		List<Order_detail> list = new ArrayList<Order_detail>();
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, id_order);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order_detail  item = new Order_detail();
				item.setId(rs.getInt("id"));
				item.setProductname(rs.getString("productname"));
				item.setSize(rs.getString("name"));
				item.setQuantity(rs.getInt("amount"));
				list.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		Item_order_service order_service = new Item_order_service();
		List<Order_detail> list = order_service.getListItemOrder("DH-1HK5R11D30");
		for(Order_detail detail :list) {
			System.out.println(detail.toString());
		}
	}
}
