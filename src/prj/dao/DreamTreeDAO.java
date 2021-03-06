package prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prj.datasource.DBConnection;
import prj.dto.DreamTreeInfo;

public class DreamTreeDAO {
 private Connection conn;
	
	 public DreamTreeDAO() {
		// TODO Auto-generated constructor stub
	 {
		try {
			conn = DBConnection.getInstance();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 }

	public List<String> selectRegion(String region) throws SQLException {
		List<String> list_id = new ArrayList<String>();
		String sql="select*from tbl_baseinfo where region=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, region);
		
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()) {
			String CAM_ID =rs.getString("CAM_ID");
			list_id.add(CAM_ID);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return list_id;
	}

	public List<String> selectTheme(String theme) throws SQLException {
		List<String> list_id = new ArrayList<String>();
		String sql = "select*from tbl_baseinfo where theme=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, theme);
		
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
		String list_themeid= rs.getString("CAM_ID");
		list_id.add(list_themeid);
		}
		rs.close();
		psmt.close();
		conn.close();
		
		return list_id;
	}

	public List<String> search(String title) throws SQLException {
		List<String>list_serachId= new ArrayList<String>();
		String sql= "select*from tbl_baseinfo where name like ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, "%"+title+"%");
		ResultSet rs= psmt.executeQuery();
		
		while(rs.next()) {
			String list_id =rs.getString("CAM_ID");
			list_serachId.add(list_id);
		}
		rs.close();
		psmt.close();
		conn.close();
		
		
		return list_serachId;
	}

	public DreamTreeInfo selectPoint(int select_id) throws SQLException {
		String sql = "select*from tbl_baseinfo where cam_id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, select_id);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		
			String name = rs.getString("name");
	        String region = rs.getString("region");	        
	        String phone = rs.getString("phone");
	        String address = rs.getString("address");
	        String theme = rs.getString("theme");
	        String data = rs.getString("data");
	        
	        DreamTreeInfo info = new DreamTreeInfo(name, region, address, phone, theme, data);
	        
	        
	        rs.close();
			psmt.close();
			conn.close();
	
		
		return info;
	}
}
