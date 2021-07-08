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

import edu.kh.yummy.menu.model.vo.Menu;
import edu.kh.yummy.store.model.vo.Store;

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



	/** 가게 상세보기store 정보 DAO
	 * @param conn
	 * @param storeNo
	 * @return store
	 * @throws Exception
	 */
	public Store storeDetail(Connection conn, int storeNo) throws Exception{
		
		Store store = null;
		
		String sql = prop.getProperty("storeDetail");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, storeNo); // 스토어 넘버로 조회
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				store = new Store();
				
				store.setStoreName(rs.getString("STORE_NM"));
				store.setStorePhone(rs.getString("STORE_PHONE"));
				store.setStoreAddr(rs.getString("STORE_ADDR"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreOpen(rs.getString("STORE_OPEN_TIME"));
				store.setStoreClose(rs.getString("STORE_CLOSE_TIME"));
				store.setStoreStory(rs.getString("STORE_STORY"));
				store.setCorNo(rs.getString("COR_NO"));
			
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return store;
	}



	/** 가게 상세보기 menu 정보 DAO
	 * @param conn
	 * @param storeNo
	 * @return list
	 * @throws Exception
	 */
	public List<Menu> storeMenu(Connection conn, int storeNo) throws Exception {

		List<Menu> list = null;
		
		String sql = prop.getProperty("storeMenu");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, storeNo);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Menu>();
			
			while(rs.next()) {
				
				Menu menu = null;
				
				int menuNo = rs.getInt("MENU_NO");
				String menuName = rs.getString("MENU_NM");
				String menuImg = rs.getString("MENU_IMG");
				int menuPrice = rs.getInt("MENU_PRICE");
				int menuSalePercent = rs.getInt("MENU_SALE");
				
				menu = new Menu(menuNo, menuName, menuImg, menuPrice, menuSalePercent);
				
				list.add(menu);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	

	/** 가게 정보 등록 DAO
	 * @param conn
	 * @param store
	 * @param memberNo 
	 * @return result
	 * @throws Exception
	 */
	public int StoreDAO(Connection conn, Store store, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			  String sql = prop.getProperty("createstore");
		         
		      pstmt = conn.prepareStatement(sql);
		      
		      pstmt.setString(1, store.getStoreName());
		      pstmt.setString(2, store.getStorePhone());
		      pstmt.setString(3, store.getStoreAddr());
		      pstmt.setString(4, store.getStoreImg());
		      pstmt.setString(5, store.getStoreOpen());
		      pstmt.setString(6, store.getStoreClose());
		      pstmt.setString(7, store.getStoreStory());
		      pstmt.setString(8, store.getCorNo());
		      pstmt.setInt(9, store.getCategoryNo());
		      pstmt.setInt(10, memberNo);
		      
		      result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}
		
		return result;
	}





}
