package edu.kh.yummy.menu.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import edu.kh.yummy.menu.model.vo.Menu;
import edu.kh.yummy.notice.model.dao.Notice2DAO;

public class MenuDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL구문을 읽어와 저장할 Properties 객체 참조 변수 선언 
	private Properties prop = null;
	
	public MenuDAO(){
		String filePath =
				MenuDAO.class.getResource("/edu/kh/yummy/sql/menu/menu-query.xml").getPath();

		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로부터 XML 파일을 읽어와 prop에 저장 
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 조회할 때 
	// loginMember.memberNo를 조회하는 sql where구문 위치홀더에 member_no 부분에 넣는다
	
	/** 메뉴 정보 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return menuList
	 * @throws Exception
	 */
	public List<Menu> selectMenuList(Connection conn, int memberNo) throws Exception{
		
		List<Menu> menuList = new ArrayList<Menu>();
		
		String sql = prop.getProperty("selectMenuList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				Menu menu = new Menu();
				
				menu.setMenuNo(rs.getInt("MENU_NO"));
				menu.setMenuName(rs.getString("MENU_NM"));
				menu.setMenuImg(rs.getString("MENU_IMG"));
				menu.setMenuPrice(rs.getInt("MENU_PRICE"));
				menu.setMenuSalePercent(rs.getInt("MENU_SALE"));
				menu.setStoreNo(rs.getInt("STORE_NO"));
				menu.setMemberNo(rs.getInt("MEMBER_NO"));
				menu.setMenuStatus(rs.getString("MENU_STATUS"));


				menuList.add(menu);
				

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return menuList;
	}
	
	/** 메뉴 수정 DAO
	 * @param conn
	 * @param menu
	 * @return result
	 * @throws Exception
	 */

	
	public int updateMenu(Connection conn, Menu menu) throws Exception{
		int result = 0;
		
		String sql = prop.getProperty("updateMenu");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setInt(2, menu.getMenuPrice());
			pstmt.setInt(3, menu.getMenuSalePercent());
			pstmt.setString(4, menu.getMenuImg());
			pstmt.setInt(5, menu.getMenuNo());
			
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 메뉴 삭제 DAO
	 * @param conn
	 * @param menuNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteMenu(Connection conn, int menuNo) throws Exception{
		int result = 0;
		String sql = prop.getProperty("deleteMenu");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, menuNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 메뉴 등록 DAO
	 * @param conn
	 * @param menu
	 * @return result
	 * @throws Exception
	 */
	public int insertMenu(Connection conn, Menu menu) throws Exception{
		int result = 0;
		String sql = prop.getProperty("insertMenu");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setString(2, menu.getMenuImg());
			pstmt.setInt(3, menu.getMenuPrice());
			pstmt.setInt(4, menu.getMenuSalePercent());
			pstmt.setInt(5, menu.getStoreNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}



}
