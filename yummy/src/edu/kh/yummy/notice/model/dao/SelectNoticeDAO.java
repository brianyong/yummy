package edu.kh.yummy.notice.model.dao;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.yummy.notice.model.vo.Notice;
import edu.kh.yummy.notice.model.vo.Pagination;

public class SelectNoticeDAO {
	
	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL구문을 읽어와 저장할 Properties 객체 참조 변수 선언 
	private Properties prop = null;
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML 파일을 읽어와 prop에 저장 
	public SelectNoticeDAO() {
		
		// member-query.xml 파일의 경로 얻어오기
		String filePath =
				SelectNoticeDAO.class.getResource("/edu/kh/yummy/sql/notice/selectNotice-query.xml").getPath();

		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로부터 XML 파일을 읽어와 prop에 저장 
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 전체 게시글 수 조회 DAO
	 * @param conn
	 * @param cp
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int cp) throws Exception{

		int listCount = 0;
		
		String sql = prop.getProperty("getListCount");
		
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

	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return noticeList
	 * @throws Exception
	 */
	public List<Notice> selectNoticeList(Connection conn, Pagination pagination) throws Exception{

		List<Notice> noticeList = new ArrayList<Notice>();
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rs.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setCreateDate(rs.getTimestamp("CREATE_DT"));

				
				noticeList.add(notice);
				
				//System.out.println(notice);

			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return noticeList;
	}

	/** 게시글 상세 조회 DAO
	 * @param conn
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	public Notice selectNotice(Connection conn, int noticeNo) throws Exception{
		Notice notice = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rs = pstmt.executeQuery();
			
			notice = new Notice();
			
			if(rs.next()) {
				
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setCreateDate(rs.getTimestamp("CREATE_DT"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setMemberNo(rs.getInt("MEMBER_NO"));
				notice.setNoticeNo(rs.getInt("NOTICE_NO"));
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return notice;
	}

	

}
