package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Size;

public class Size_service {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Size> Size() {
		List<Size> list = new ArrayList<>();
		String sql = "select * from size";
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Size size = new Size();
				size.setId(rs.getInt("id"));
				size.setName(rs.getString("name"));
				list.add(size);
			}
		} catch (Exception e) {

		}
		return list;
	}
	public Size getSizeById(int id) {
		String sql = "select * from size WHERE id = ?";
		Size size = new Size();
		try {
			conn = Database.Connect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				size.setId(rs.getInt("id"));
				size.setName(rs.getString("name"));
				
			}
		} catch (Exception e) {

		}
		return size;
	}
	public static void main(String[] args) {
		Size_service ss = new Size_service();
		List<Size> list =ss.Size();
		String size ="M";
		String tmp =null;
		int id_tmp =0;
		int id = 0;
		for(Size s:list) {
			tmp =s.getName();
			id =s.getId();
			if(tmp.equals(size)) {
				id_tmp = id;
			}
			System.out.print(id+"\n");
		}
		System.out.print(id_tmp);
	}
}