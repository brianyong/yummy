package edu.kh.yummy.order.model.dao;

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

import edu.kh.yummy.cart.model.vo.Cart;
import edu.kh.yummy.member.model.dao.MemberDAO;
import edu.kh.yummy.menu.model.vo.Menu;
import edu.kh.yummy.order.model.vo.MemberOrder;
import edu.kh.yummy.order.model.vo.Orders;
import edu.kh.yummy.order.model.vo.Pagination;
import oracle.sql.TIMESTAMP;

public class OrdersDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;

	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장

	public OrdersDAO() {
		// member-query.xml 파일의 경로 얻어오기
		String filePath = OrdersDAO.class.getResource("/edu/kh/yummy/sql/order/order-query.xml").getPath();

		try {
			prop = new Properties();

			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 주문내역 조회 DAO
	 * 
	 * @param conn
	 * @param memberNo
	 * @return orderInfo
	 * @throws Exception
	 */
	public Orders orderInfo(Connection conn, int memberNo) throws Exception {

		Orders orderInfo = null;

		String sql = prop.getProperty("orderInfo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				orderInfo = new Orders();

				orderInfo.setOrderNo(rs.getInt("ORDER_NO"));
				orderInfo.setOrderDate(rs.getDate("ORDER_DATE"));
				orderInfo.setOrderRequest(rs.getString("ORDER_REQUEST"));
				orderInfo.setVisitTime(rs.getTimestamp("ORDER_VISIT_TIME"));

			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return orderInfo;
	}

	/**
	 * 
	 * 주문내역 view DAO
	 * 
	 * @param conn
	 * @param pagination
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> orderListView(Connection conn, Pagination pagination, int memberNo)
			throws Exception {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		String sql = prop.getProperty("orderListView");

		try {

			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("orderDate", rs.getDate("ORDER_DATE"));
				map.put("storeNo", rs.getInt("STORE_NO"));
				map.put("storeName", rs.getString("STORE_NM"));
				map.put("storeAddress", rs.getString("STORE_ADDR"));
				map.put("orderNo", rs.getInt("ORDER_NO"));

				list.add(map);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return list;

	}

	/**
	 * 전체 주문내역수 조회 DAO
	 * 
	 * @param conn
	 * @param cp
	 * @param memberNo
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int cp, int memberNo) throws Exception {

		int listCount = 0;

		String sql = prop.getProperty("getListCount");

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);

		}
		return listCount;
	}

	/**
	 * @param conn
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public List<MemberOrder> selectOrderMenuList(Connection conn, int orderNo) throws Exception {

		List<MemberOrder> menuList = new ArrayList<MemberOrder>();

		String sql = prop.getProperty("selectOrderMenuList");

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberOrder menu = new MemberOrder();
				menu.setMenuNo(rs.getInt("MENU_NO"));
				menu.setMenuName(rs.getString("MENU_NM"));
				menu.setMenuAmount(rs.getInt("MENU_AMOUNT"));
				menu.setMenuPrice(rs.getInt("MENU_PRICE"));

				menuList.add(menu);
			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return menuList;

	}

	/**
	 * 다음 주문번호 조회
	 * 
	 * @param conn
	 * @return orderNo
	 * @throws Exception
	 */
	public int nextOrderNo(Connection conn) throws Exception {

		int orderNo = 0;

		String sql = prop.getProperty("nextOrderNo");

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				orderNo = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return orderNo;
	}

	/**
	 * 주문하기 DAO1
	 * 
	 * @param orderNo
	 * @param orderVisitTime
	 * @param orderRequest
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int placeOrder1(Connection conn, int orderNo, String orderVisitTime, String orderRequest, int memberNo)
			throws Exception {

		int result = 0;

		String sql = prop.getProperty("placeOrder1");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderNo);
			pstmt.setString(2, orderRequest);
			pstmt.setString(3, orderVisitTime);
			pstmt.setInt(4, memberNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/*	*//**
			 * 주문하기 DAO2
			 * 
			 * @param conn
			 * @param orderNo
			 * @param menuNo
			 * @param menuAmount
			 * @return
			 * @throws Exception
			 *//*
				 * public int placeOrder2(Connection conn, int orderNo, int menuNo, int
				 * menuAmount) throws Exception{
				 * 
				 * int result = 0;
				 * 
				 * String sql = prop.getProperty("placeOrder2"); try { pstmt =
				 * conn.prepareStatement(sql);
				 * 
				 * pstmt.setInt(1, orderNo); pstmt.setInt(2, menuNo); pstmt.setInt(3,
				 * menuAmount);
				 * 
				 * result = pstmt.executeUpdate();
				 * 
				 * } finally { close(pstmt);
				 * 
				 * } return result;
				 * 
				 * }
				 */

	/**
	 * 주문하기 DAO2
	 * @param conn
	 * @param cart
	 * @param orderNo
	 * @return result
	 * @throws Exception
	 */
	public int insertOrderDetail(Connection conn, Cart cart, int orderNo) throws Exception{
		// TODO Auto-generated method stub

		int result = 0;

		String sql = prop.getProperty("placeOrder2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, cart.getMenuNo());
			pstmt.setInt(3, cart.getMenuAmount());
			
			result = pstmt.executeUpdate();
		
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
