package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.News;
import Model.Product;

public class News_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public News getNewsById(int id) {
		News nw = new News();
		String query = "select * from news where id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				nw.setId(rs.getInt(1));
				nw.setTitle(rs.getString(2));
				nw.setImage(rs.getString(4));
				nw.setDescribe(rs.getString(3));
				nw.setContent(rs.getString(5));
				nw.setDatesub(rs.getDate(6));
				nw.setStatus(rs.getInt(7));

			}
		} catch (Exception e) {
		}
		return nw;
	}
	public List<News> Allnews(int indexpage) {
		List<News> list = new ArrayList<News>();
		String sql = "select * from news order by id desc offset ? rows fetch next 12 rows only;";
		PreparedStatement pstm;
		try {
			conn = Database.Connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (indexpage - 1) * 12);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News nw = new News();
				nw.setId(rs.getInt(1));
				nw.setTitle(rs.getString(2));
				nw.setDescribe(rs.getString(3));
				nw.setImage(rs.getString(4));
				nw.setContent(rs.getString(5));
				nw.setDatesub(rs.getDate(6));
				nw.setStatus(rs.getInt(7));
				list.add(nw);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int CountNews() {
		String sql = "select count(*) from news";
		try {
			conn = Database.Connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public void insertNews(String title, String describle, String image, String content) {

		String query = "INSERT INTO news (title,[image], datesub, describe,content) values(?,?,GETDATE(),?,?)";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(3, describle);
			ps.setString(2, image);
			ps.setString(4, content);
		
			ps.execute();

		} catch (Exception e) {

		}

	}
	public void deleteNewsbyId(int id) {
		String query = "DELETE FROM news where id=?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();

		} catch (Exception e) {
		}
	}
	public void updateNews(String title, String image, String describe, String content,
			  int status, int id) {
		String query = "UPDATE news SET title=?,[image]=?,describe=?,content=?,[status]=? WHERE id =?";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(query);
			ps.setString(1,title);
			ps.setString(2, image);
			ps.setString(3, describe);
			ps.setString(4, content);
			ps.setInt(5, status);
			ps.setInt(6, id);
			ps.executeUpdate();

		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		News_service pm = new News_service();
		pm.updateNews("a", "a.png", "a", "a", 1, 1016);
		
	}

}
