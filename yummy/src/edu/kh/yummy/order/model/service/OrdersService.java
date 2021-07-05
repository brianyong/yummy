package edu.kh.yummy.order.model.service;

import edu.kh.yummy.member.model.dao.MemberDAO;
import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.yummy.order.model.dao.OrdersDAO;
import edu.kh.yummy.order.model.vo.Orders;

public class OrdersService {
	
	
	private OrdersDAO dao = new OrdersDAO();

	
	/**
	 * 주문내역 조회 서비스
	 * @param memberNo
	 * @return orderInfo
	 * @throws Exception
	 */
	public Orders orderInfo(int memberNo) throws Exception{
		
		
		Connection conn = getConnection();
		
		Orders orderInfo = dao.orderInfo(conn, memberNo);
		
		close(conn);
	
		
		
		return orderInfo;
	}
}
