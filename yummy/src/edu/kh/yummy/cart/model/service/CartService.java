package edu.kh.yummy.cart.model.service;

import edu.kh.yummy.cart.model.dao.CartDAO;
import edu.kh.yummy.store.model.vo.Store;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
public class CartService {

	private CartDAO dao = new CartDAO();
	
	public Store selectStore(int storeNo) throws Exception {
		
		Connection conn = getConnection();
		
		Store store = dao.selectStore(conn, storeNo);
		
		close(conn);
		return store;
	}

}
