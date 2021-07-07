package edu.kh.yummy.store.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.yummy.menu.model.vo.Menu;
import edu.kh.yummy.store.model.dao.StoreDAO;
import edu.kh.yummy.store.model.vo.Store;

public class StoreService {
	
	private StoreDAO dao = new StoreDAO();

	/** 가게 상세보기 store 정보 Service
	 * @param storeNo
	 * @return store
	 * @throws Exception
	 */
	public Store storeDetail(int storeNo) throws Exception{

		Connection conn = getConnection();
		
		Store store = dao.storeDetail(conn, storeNo);
		
		close(conn);
		
		return store;
	}

	/** 가게 상세보기 menu 정보 Service
	 * @param storeNo
	 * @return list
	 * @throws Exception
	 */
	public List<Menu> storeMenu(int storeNo) throws Exception {

		Connection conn = getConnection();
		
		List<Menu> list = dao.storeMenu(conn, storeNo);
		
		close(conn);
		
		return list;
	}



}
