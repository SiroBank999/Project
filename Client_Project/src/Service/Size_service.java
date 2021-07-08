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
}
