package edu.kh.yummy.store.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.yummy.store.model.dao.StoreDAO;

public class StoreService {
	
	private StoreDAO dao = new StoreDAO();

	/** 가게 상세보기 Service
	 * @param storeNo
	 * @return list
	 * @throws Exception
	 */
	public List<Map<String, Object>> storeView(int storeNo) throws Exception {

		Connection conn = getConnection();
		
		List<Map<String, Object>> list = dao.storeDetail(conn, storeNo);
		
		close(conn);
		
		return list;
	}

}
