package edu.kh.yummy.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.yummy.faq.model.service.SelectFaqService;
import edu.kh.yummy.faq.model.vo.Faq;
import edu.kh.yummy.faq.model.vo.Pagination;

@WebServlet("/faq/*")
public class SelectFaqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();          
		String contextPath = request.getContextPath(); 
		String command = uri.substring( (contextPath + "/faq/").length() );
		
		String path = null; 
		RequestDispatcher view = null; 
		
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			SelectFaqService service = new SelectFaqService();
			
			// 현재 페이지
			int cpage = request.getParameter("cpage") == null? 1 : Integer.parseInt( request.getParameter("cpage") );
			
			// faq 목록 조회 Controller
			if(command.equals("list")) {
				
				Pagination pagination = service.pagination(cpage);
				
				// System.out.println(pagination);
				
				// pagination을 이용해서 자주묻는질문 목록에 보여줘야 할 내용을 DB에서 조회
				List<Faq> faqList = service.selectFaqList(pagination);
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("faqList", faqList);
				
				path = "/WEB-INF/views/faq/faqList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			// faq 상세 조회 Controller
			else if(command.equals("detail")){
				
				int faqNo = Integer.parseInt(request.getParameter("no"));
				
				Faq faq = service.selectFaq(faqNo);
				
				request.setAttribute("faq", faq);
				
				path = "/WEB-INF/views/faq/faqDetail.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
