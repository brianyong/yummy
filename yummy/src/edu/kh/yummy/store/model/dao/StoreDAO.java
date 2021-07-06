package edu.kh.yummy.store.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StoreDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Properties prop = null;

	public StoreDAO() {

		String filePath = CategoryDAO.class.getResource("/edu/kh/yummy/sql/store/store-query.xml").getPath();                    
				
		try {
			prop = new Properties();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/** 가게 상세보기 DAO
	 * @param conn
	 * @param storeNo
	 * @return list
	 * @throws Exception
	 */
	public List<Map<String, Object>> storeDetail(Connection conn, int storeNo) throws Exception {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		String sql = prop.getProperty("storeDetail");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, storeNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("storeName", rs.getString(1));
				map.put("storePhone", rs.getString(2));
				map.put("storeAddr", rs.getString(3));
				map.put("storeImg", rs.getString(4));
				map.put("storeOpen", rs.getString(5));
				map.put("storeClose", rs.getString(6));
				map.put("storeStory", rs.getString(7));
				map.put("corNo", rs.getString(8));
				map.put("menuNo", rs.getInt(9));
				map.put("menuName", rs.getString(10));
				map.put("menuImg", rs.getString(11));
				map.put("menuPrice", rs.getInt(12));
				map.put("menuSale", rs.getInt(13));
				
				list.add(map);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}
