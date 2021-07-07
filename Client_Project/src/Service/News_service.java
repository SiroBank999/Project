package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Model.News;
import Model.Product;

public class News_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<News> getNews() {
		List<News> list = new ArrayList<>();
		String query = "select top 3 * from news ";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list ;
	}
	public News getNewbyId(int id) {
		News nw = new News();
		String query = "select*from news where id= ? ";
		try {
			
		
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				nw.setId(rs.getInt(1));
				nw.setTitle(rs.getString(2));
				nw.setDescribe(rs.getString(3));
				nw.setImage(rs.getString(4));
				nw.setContent(rs.getString(5));
				nw.setDatesub(rs.getDate(6));
				nw.setId_admin(rs.getInt(7));
				nw.setStatus(rs.getInt(8));
				}
			
		}
		catch (Exception e) {
		}
		
		
		return nw;
	
	}
	public int getTotalNews() {
		String query = "select count(*) from news";
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
	public List<News> pagingNews(int index){
		List<News> list = new ArrayList<>();
		String query = "SELECT * FROM news \r\n"
				+ "ORDER BY id DESC \r\n"
				+ "offset ? rows fetch next 3 rows only;";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1) * 4);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
}
