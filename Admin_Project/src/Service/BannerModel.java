package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Object.Banner;

public class BannerModel {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertBanner(String title,String image) {
		String query ="INSERT INTO banner (title,image) VALUES(?,?)";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setString(1,title);
			ps.setString(2, image);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Banner> getBanner(){
		List<Banner> list = new ArrayList<>();
		String query ="SELECT  * FROM banner \r\n"
				+ "ORDER BY id DESC\r\n"
				+ "LIMIT 1";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Banner(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
		} catch (Exception e) {
			
		}
		return list;
	}

}
