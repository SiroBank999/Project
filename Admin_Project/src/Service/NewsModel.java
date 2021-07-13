package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Object.Category;
import Object.News;
import Object.Product;


public class NewsModel {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<News> getNews() {
		List<News> listNews = new ArrayList<>();
		String query = "select*from news ";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				listNews.add(new News(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return listNews;
	}
	public List<News> getNewsLimit() {
		List<News> listNews = new ArrayList<>();
		String query = "select*from news limit 3 ";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				listNews.add(new News(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return listNews;
	}
	public News getNewbyId(int id) {
		News nw = new News();
		String query = "select*from news where id= ? ";
		try {
			
		
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				nw.setId(rs.getInt(1));
				nw.setTitle(rs.getString(2));
				nw.setDescribe(rs.getString(3));
				nw.setImage(rs.getString(4));
				nw.setContent(rs.getString(5));
				nw.setId_admin(rs.getInt(6));
				nw.setType(rs.getString(8));
				}
			
		}
		catch (Exception e) {
		}
		
		
		return nw;
	
	}
	public int getTotalNews() {
		String query = "select count(*) from news";
		try {
			conn = Database.ketNoi();
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
				+ "LIMIT ? , 9";
		try {
			conn = Database.ketNoi();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1) * 9);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
}
