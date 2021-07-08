package edu.kh.yummy.store.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.yummy.store.model.dao.CategoryDAO;
import edu.kh.yummy.store.model.vo.Store;

public class CategoryService {

	private CategoryDAO dao = new CategoryDAO();

	/** 카테고리별 가게 보기 Service
	 * @param categoryNo
	 * @return list
	 * @throws Exception
	 */
	public List<Map<String, Object>> storeView(int categoryNo) throws Exception {

		Connection conn = getConnection();

		List<Map<String, Object>> list = dao.storeView(conn, categoryNo);

		close(conn);

		return list;
	}

	/** 가게 전체보기 Service
	 * @param categoryNo
	 * @return list
	 * @throws Exception
	 */
	public List<Map<String, Object>> storeViewAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> list = dao.storeViewAll(conn);

		close(conn);
		
		return list;
	}

}
