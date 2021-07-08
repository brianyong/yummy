package edu.kh.yummy.notice.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.yummy.notice.model.dao.Notice2DAO;
import edu.kh.yummy.notice.model.vo.Notice;

public class Notice2Service {

	private Notice2DAO dao = new Notice2DAO();

	
	/** 게시글 삽입 Service
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Notice notice) throws Exception{
		Connection conn = getConnection();
		
		// 다음 게시글 번호 얻어오기
		// 왜? 동시 다발적인 INSERT 발생 시 시퀀스.NEXTVAL가 연속으로 이루어져
		// 이후 시퀀스.CURRVAL가 호출될 때 원하는 값을 못얻어오는 경우가 생기기 때문에...
		int noticeNo = dao.nextNoticeNo(conn);
		
		int result = 0;
		
		if(noticeNo > 0) {
			notice.setNoticeNo(noticeNo);
			
			// 게시글 내용의 줄바꿈을 <br>태그로 변환 + 크로스사이트 스크립팅방지처리
			String noticeContent = notice.getNoticeContent();
			noticeContent = replaceParameter(noticeContent);
			noticeContent = noticeContent.replaceAll("\r\n", "<br>");
			
			notice.setNoticeContent(noticeContent);
			
			System.out.println(noticeContent);
			result = dao.insertNotice(conn, notice);
			
			commit(conn);
			result = noticeNo;
			
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 크로스 사이트 스크립트 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		
		return result;
	}

	/** 공지사항 수정 Service
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int updateNotice(Notice notice) throws Exception{
		Connection conn = getConnection();
		
		notice.setNoticeContent(replaceParameter( notice.getNoticeContent()));
		notice.setNoticeTitle(replaceParameter(notice.getNoticeTitle()));
		notice.setNoticeContent(notice.getNoticeContent().replaceAll("\r\n", "<br>"));
		
		// 공지사항 수정
		int result = dao.updateNotice(conn, notice);
		
		if(result > 0) { // 수정 성공 시
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/** 공지사항 삭제 Service
	 * @param noticeNo
	 * @return result;
	 * @throws Exception
	 */
	public int deleteNotice(int noticeNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteNotice(conn, noticeNo);
		
		if(result > 0) { // 삭제 성공 시
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	
	
}
