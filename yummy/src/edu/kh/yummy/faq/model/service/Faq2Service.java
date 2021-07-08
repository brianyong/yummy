package edu.kh.yummy.faq.model.service;


import edu.kh.yummy.faq.model.dao.Faq2DAO;
import edu.kh.yummy.faq.model.vo.Faq;
import edu.kh.yummy.faq.model.vo.Pagination;
import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;


public class Faq2Service {

	private Faq2DAO dao = new Faq2DAO();
	
	
	/** faq 삽입 Service
	 * @author Choiyujeong
	 * @param memberNo
	 * @param faqTitle
	 * @param faqContent
	 * @return result
	 * @throws Exception
	 */
	public int insertFaq(Faq faq) throws Exception {
		
		Connection conn = getConnection();
		
		int faqNo = dao.nextFaqNo(conn);
		
		int result = 0;
		if(faqNo > 0) {
			faq.setFaqNo(faqNo);
			
			
			// 크로스 사이트 스트립트 방지 & 줄바꿈 변환
			String faqTitle = faq.getFaqTitle();
			String faqContent = faq.getFaqContent();
			replaceParameter(faqTitle);
			replaceParameter(faqContent);
			
			faqContent  = faqContent.replaceAll("\r\n", "<br>");
			
			faq.setFaqContent(faqContent);
			faq.setFaqTitle(faqTitle);
			
			
			result = dao.insertFaq(conn, faq );
			
			if(result > 0){
				commit(conn);
				result = faqNo;
			}else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return result;
	}

	
	/** faq 삭제 Service
	 * @param faqNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteFaq(int faqNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		result = dao.deleteFaq(conn, faqNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
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


	/** faq 수정
	 * @author Choiyujeong
	 * @param faq
	 * @return result
	 * @throws Exception
	 */
	public int updateFaq(Faq faq) throws Exception {
		
		Connection conn = getConnection();
		
		// 크로스 사이트 스트립트 방지 & 줄바꿈 변환
		String faqTitle = faq.getFaqTitle();
		String faqContent = faq.getFaqContent();
		replaceParameter(faqTitle);
		replaceParameter(faqContent);
		
		faqContent  = faqContent.replaceAll("\r\n", "<br>");
		
		faq.setFaqContent(faqContent);
		faq.setFaqTitle(faqTitle);
		
		int result = dao.updateFaq(conn,faq);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}



}
