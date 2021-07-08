package edu.kh.yummy.order.model.service;

import edu.kh.yummy.member.model.dao.MemberDAO;
import edu.kh.yummy.menu.model.vo.Menu;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.yummy.order.model.dao.OrdersDAO;
import edu.kh.yummy.order.model.vo.MemberOrder;
import edu.kh.yummy.order.model.vo.Orders;
import edu.kh.yummy.order.model.vo.Pagination;

public class OrdersService {

	private OrdersDAO dao = new OrdersDAO();

	/**
	 * 주문내역 조회 서비스
	 * 
	 * @param memberNo
	 * @return orderInfo
	 * @throws Exception
	 */
	public Orders orderInfo(int memberNo) throws Exception {

		Connection conn = getConnection();

		Orders orderInfo = dao.orderInfo(conn, memberNo);

		close(conn);

		return orderInfo;
	}

	

	/**
	 * 고객별 주문 내역 Service
	 * @param pagination 
	 * @param orderNo
	 * @return list
	 * @throws Exception
	 */
	public List<Map<String, Object>> orderListView(Pagination pagination, int memberNo) throws Exception{
		Connection conn = getConnection();

		List<Map<String, Object>> list = dao.orderListView(conn,pagination,memberNo);
		
		for(Map<String, Object> order : list) {
			System.out.println("orderNo : " + (int)order.get("orderNo"));
			List<MemberOrder> menuList =  dao.selectOrderMenuList(conn, (int)order.get("orderNo"));
			
			order.put("menuList", menuList);
		}
		
		
		close(conn);

		return list;
		
	}



	/**
	 * 페이징 처리 객체 생성 용 Service 
	 * @param cp
	 * @param memberNo
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		//DB에서 전체 게시글 수 + 게시판 이름을 얻어옴 
		int listCount = dao.getListCount(conn, cp, memberNo);
		
		close(conn);
		
		
		return new Pagination(cp, listCount);
	}



	/**
	 * 주문하기 서비스
	 * @param storeName
	 * @param storeAddress
	 * @param menuName
	 * @param menuAmount
	 * @param menuSaleCost
	 * @return result
	 * @throws Exception
	 */
	public int placeOrder(String storeName, String storeAddress, String menuName, int menuAmount, int menuSaleCost) throws Exception{
		
		
		Connection conn = getConnection();
		
		int result = dao.placeOrder(conn, storeName, storeAddress, menuName, menuAmount, menuSaleCost);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		
		return result;
	}
}
