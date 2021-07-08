package edu.kh.yummy.cart.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.yummy.cart.model.vo.Cart;
import edu.kh.yummy.order.model.dao.OrdersDAO;
import edu.kh.yummy.store.model.vo.Store;

import static edu.kh.yummy.common.JDBCTemplate.*;

public class CartDAO {
	
	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;

	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장

	public CartDAO() {
		// member-query.xml 파일의 경로 얻어오기
		String filePath = OrdersDAO.class.getResource("/edu/kh/yummy/sql/cart/cart-query.xml").getPath();

		try {
			prop = new Properties();

			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	

	public Store selectStore(Connection conn, int storeNo) throws Exception{
		Store store = null;
		
		String sql = prop.getProperty("selectStore");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, storeNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				store = new Store();
				
				store.setStoreName(rs.getString(1));
				store.setStoreAddr(rs.getString(2));
			}
			
			
		}finally {
			
			
			close(rs);
			close(pstmt);
		}
		return store;
	}

}
