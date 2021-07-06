package edu.kh.yummy.gps.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static edu.kh.yummy.common.JDBCTemplate.*;

import edu.kh.yummy.store.model.vo.Store;

public class GpsService {
	
	private GpsDAO dao = new GpsDAO();

	/** 주소 검색 시 구 단위의 가게 정보 조회
	 * @author Choiyujeong
	 * @param searchGu
	 * @return selectList
	 */
	public List<Store> selectList(String searchGu) throws Exception {
		
		Connection conn = getConnection();
		
		String condition = " WHERE STORE_ADDR LIKE '%" + searchGu +"%' ";
				
		List<Store> sList = dao.selectList(conn, condition);
		
		close(conn);
		
		return sList;
	}

}
