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

import edu.kh.yummy.store.model.vo.Store;

public class CategoryDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
		private Statement stmt = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		private Properties prop = null;
		
		
		public CategoryDAO() {
			String filePath 
				= CategoryDAO.class.getResource("/edu/kh/yummy/sql/store/category-query.xml").getPath();                    
			
			try {
				prop = new Properties();
				
				prop.loadFromXML(new FileInputStream(filePath));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}


		/** 카테고리별 가게 보기 DAO
		 * @param conn
		 * @param categoryNo
		 * @return
		 * @throws Exception
		 */
		public List<Map<String, Object>> storeView(Connection conn, int categoryNo) throws Exception {

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			String sql = prop.getProperty("storeView");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, categoryNo);
				
				rs = pstmt.executeQuery();
						
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("storeNo", rs.getInt(1));
					map.put("storeName", rs.getString(2));
					map.put("storeImg", rs.getString(3));
					map.put("storeCate", rs.getString(4));
					map.put("goodCount", rs.getString(5));
					
					list.add(map);
				}
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return list;
		}


		/**가게 전체보기 DAO
		 * @param conn
		 * @param categoryNo
		 * @return list
		 * @throws Exception
		 */
		public List<Map<String, Object>> storeViewAll(Connection conn) throws Exception{
			
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			String sql = prop.getProperty("storeViewAll");
			
			try {
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
						
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("storeNo", rs.getInt(1));
					map.put("storeName", rs.getString(2));
					map.put("storeImg", rs.getString(3));
					map.put("storeCate", rs.getString(4));
					map.put("goodCount", rs.getString(5));
					
					list.add(map);
				}
				
			} finally {
				close(rs);
				close(stmt);
			}
			
			return list;
		}
}
