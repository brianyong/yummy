package edu.kh.yummy.notice.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;



import edu.kh.yummy.notice.model.dao.SelectNoticeDAO;
import edu.kh.yummy.notice.model.vo.Notice;
import edu.kh.yummy.notice.model.vo.Pagination;

public class SelectNoticeService {

	private SelectNoticeDAO dao = new SelectNoticeDAO();

	/** 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp) throws Exception{
		
		Connection conn = getConnection();
		
		// DB에서 전체 게시글 수 얻어옴
		int listCount = dao.getListCount(conn, cp);
		
		

		close(conn);
		
		return new Pagination(cp, listCount);
	}

	
	/** 게시글 목록 조회 Service
	 * @param pagination
	 * @return noticeList
	 * @throws Exception
	 */
	public List<Notice> selectNoticeList(Pagination pagination) throws Exception{

		Connection conn = getConnection();
		
		List<Notice> noticeList = dao.selectNoticeList(conn, pagination);
		
		close(conn);
		
		return noticeList;
		
	}


	/** 게시글 상세 조회 Service
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	public Notice selectNotice(int noticeNo) throws Exception {
		Connection conn = getConnection();
		
		Notice notice = dao.selectNotice(conn, noticeNo);
		
		
		close(conn);
				
		return notice;
	}
}
