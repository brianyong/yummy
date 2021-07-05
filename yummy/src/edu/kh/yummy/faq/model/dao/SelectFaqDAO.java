package edu.kh.yummy.faq.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.yummy.faq.model.vo.Faq;
import edu.kh.yummy.faq.model.vo.Pagination;

public class SelectFaqDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public SelectFaqDAO() {
		
		String filePath = SelectFaqDAO.class.getResource("/edu/kh/yummy/sql/faq/selectFaq-query.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 페이징 처리 객체 생성 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param cpage
	 * @return listCount
	 * @throws Exception
	 */
	public int pagination(Connection conn, int cpage) throws Exception {
		
		int listCount = 0;
		
		String sql = prop.getProperty("pagination");
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}

	/** 자주묻는 질문 목록 조회 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param pagination
	 * @return fagList
	 * @throws Exception
	 */
	public List<Faq> selectFaqList(Connection conn, Pagination pagination) throws Exception {
		
		List<Faq> faqList = new ArrayList<Faq>();
		
		String sql = prop.getProperty("selectFaqList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Faq faq = new Faq();
				
				faq.setFaqNo(rs.getInt("FAQ_NO"));
				faq.setFaqTitle(rs.getString("FAQ_TITLE"));
				faq.setMemberName(rs.getString("MEMBER_NM"));
				faq.setCreateDate(rs.getTimestamp("CREATE_DT"));
				
				faqList.add(faq);				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return faqList;
	}

	/** faq 상세 조회 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param faqNo
	 * @return faq
	 * @throws Exception
	 */
	public Faq selectFaq(Connection conn, int faqNo) throws Exception{
		
		Faq faq = null;
		
		String sql = prop.getProperty("selectFaq");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faqNo);
			
			rs = pstmt.executeQuery();
			
			faq = new Faq();
			
			if(rs.next()) {
				
				faq.setFaqNo(faqNo);
				faq.setFaqTitle(rs.getString("FAQ_TITLE"));
				faq.setFaqContent(rs.getString("FAQ_CONTENT"));
				faq.setCreateDate(rs.getTimestamp("CREATE_DT"));
				faq.setMemberNo(rs.getInt("MEMBER_NO"));
				faq.setMemberName(rs.getString("MEMBER_NM"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return faq;
	}




}
