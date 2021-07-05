package edu.kh.yummy.notice.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.yummy.notice.model.vo.Notice;

public class Notice2DAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL구문을 읽어와 저장할 Properties 객체 참조 변수 선언 
	private Properties prop = null;
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML 파일을 읽어와 prop에 저장 
	public Notice2DAO() {
		
		// member-query.xml 파일의 경로 얻어오기
		String filePath =
				Notice2DAO.class.getResource("/edu/kh/yummy/sql/notice/notice2-query.xml").getPath();

		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로부터 XML 파일을 읽어와 prop에 저장 
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 다음 게시글 조회 DAO
	 * @param conn
	 * @return noticeNo
	 * @throws Exception
	 */
	public int nextNoticeNo(Connection conn) throws Exception{
		int noticeNo = 0;
		
		String sql = prop.getProperty("nextNoticeNo");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				noticeNo = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		return noticeNo;
	}

	/** 게시글 삽입 DAO
	 * @param conn
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Connection conn, Notice notice) throws Exception{
		int result = 0;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, notice.getNoticeNo());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeContent());
			pstmt.setInt(4, notice.getMemberNo());
			
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 공지사항 수정 DAO
	 * @param conn
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int updateNotice(Connection conn, Notice notice) throws Exception{
		int result = 0;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 공지사항 삭제 DAO
	 * @param conn
	 * @param noticeNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteNotice(Connection conn, int noticeNo) throws Exception{
		int result = 0;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

}
