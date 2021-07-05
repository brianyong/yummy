package edu.kh.yummy.order.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.yummy.member.model.dao.MemberDAO;
import edu.kh.yummy.order.model.vo.Orders;

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
			
			if(rs.next()) {
				
				orderInfo = new Orders();
				
				orderInfo.setOrderNo(rs.getInt("ORDER_NO"));
				orderInfo.setOrderDate(rs.getDate("ORDER_DATE"));
				orderInfo.setOrderRequest(rs.getString("ORDER_REQUEST"));
				orderInfo.setVisitTime(rs.getTimestamp("ORDER_VISIT_TIME"));
			
				
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return orderInfo;
	}

}
