package edu.kh.yummy.menu.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.yummy.menu.model.dao.MenuDAO;
import edu.kh.yummy.menu.model.vo.Menu;

public class MenuService {

	private MenuDAO dao = new MenuDAO();
	
	
	/** 메뉴 정보 조회 Service
	 * @param memberNo
	 * @return menuList
	 * @throws Exception
	 */
	public List<Menu> selectMenuList(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		List<Menu> menuList = dao.selectMenuList(conn, memberNo);
		
		close(conn);
		
		return menuList;
	}
	
	/** 메뉴 수정 Service
	 * @param menu
	 * @return result
	 * @throws Exception
	 */
	public int updateMenu(Menu menu) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateMenu(conn, menu);
		
		if(result > 0) { // 수정 성공 시
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/** 메뉴 삭제 Service
	 * @param menuNo
	 * @return result;
	 * @throws Exception
	 */
	public int deleteMenu(int menuNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteMenu(conn, menuNo);
		
		if(result > 0) { // 삭제 성공 시
			commit(conn);
		}else {
			rollback(conn);
			
		}
		close(conn);
		return result;
	}

	/** 메뉴 등록 Service
	 * @param menu
	 * @return result
	 * @throws Exception
	 */
	public int insertMenu(Menu menu) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertMenu(conn, menu);
		
		if(result > 0) { // 등록 성공 시
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}






}
