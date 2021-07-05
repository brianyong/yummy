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

public class Faq2DAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public Faq2DAO() {
		
		String filePath = Faq2DAO.class.getResource("/edu/kh/yummy/sql/faq/faq2-query.xml").getPath();
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** faqNo 조회 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @return faqNo
	 * @throws Exception
	 */
	public int nextFaqNo(Connection conn) throws Exception {
		
		int faqNo = 0;
		
		String sql = prop.getProperty("nextFaqNo");
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				faqNo = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return faqNo;
	}

	/** faq 삽입 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param faq
	 * @return result
	 */
	public int insertFaq(Connection conn, Faq faq) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("insertFaq");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faq.getFaqNo());
			pstmt.setString(2, faq.getFaqTitle());
			pstmt.setString(3, faq.getFaqContent());
			pstmt.setInt(4, faq.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** faq 삭제 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param faqNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteFaq(Connection conn, int faqNo) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("deleteFaq");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}

	/** faq 수정 DAO
	 * @author Choiyujeong
	 * @param conn
	 * @param faq
	 * @return result
	 * @throws Exception
	 */
	public int updateFaq(Connection conn, Faq faq) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("updateFaq");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, faq.getFaqTitle());
			pstmt.setString(2, faq.getFaqContent());
			pstmt.setInt(3, faq.getFaqNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			
			
		}
		
		return result;
	}


}
