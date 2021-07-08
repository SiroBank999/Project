package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.ImageProduct;

public class ImageProduct_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<ImageProduct> getImage(int id_product){
		List<ImageProduct> list = new ArrayList<>();
		String query ="SELECT * FROM image_product WHERE id_product = ? ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_product);
			rs = ps.executeQuery();
			while(rs.next()) {
				ImageProduct ipd = new  ImageProduct();
				ipd.setId(rs.getInt(1));
				ipd.setImage(rs.getString(2));
				ipd.setId_product(rs.getInt(3));
				list.add(ipd);
			}
		} catch (Exception e) {
		}
		return list;
	}
	public static void main(String[] agrs) {
		
		ImageProduct_service s = new ImageProduct_service();
				List<ImageProduct> list = s.getImage(3);
				for(ImageProduct p:list) {
					System.out.print(p);
				}
	}
}
