package edu.kh.yummy.faq.model.service;


import edu.kh.yummy.faq.model.dao.SelectFaqDAO;
import edu.kh.yummy.faq.model.vo.Faq;
import edu.kh.yummy.faq.model.vo.Pagination;
import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;


public class SelectFaqService {

	private SelectFaqDAO dao = new SelectFaqDAO();
	
	/** 페이지 객체 생성용 Service
	 * @author Choiyujeong
	 * @param cpage
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination pagination(int cpage) throws Exception {
		
		Connection conn = getConnection();
		
		int listCount = dao.pagination(conn, cpage);
		
		close(conn);
		
		return new Pagination(cpage, listCount);
	}

	
	/** 자주묻는질문 목록 조회 Service
	 * @author Choiyujeong
	 * @param pagination
	 * @return faqList
	 * @throws Exception
	 */
	public List<Faq> selectFaqList(Pagination pagination) throws Exception{
		
		Connection conn = getConnection();
		
		List<Faq> faqList = dao.selectFaqList(conn, pagination);
		
		close(conn);
		
		return faqList;
	}


	/** faq 상세 조회 Service
	 * @author Choiyujeong
	 * @param faqNo
	 * @return faq
	 * @throws Exception
	 */
	public Faq selectFaq(int faqNo) throws Exception {
		
		Connection conn = getConnection();
		
		Faq faq = dao.selectFaq(conn, faqNo);
		
		close(conn);
		
		return faq;
	}

}
