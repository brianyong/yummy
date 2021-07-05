package edu.kh.yummy.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.faq.model.service.Faq2Service;
import edu.kh.yummy.faq.model.service.SelectFaqService;
import edu.kh.yummy.faq.model.vo.Faq;
import edu.kh.yummy.faq.model.vo.Pagination;
import edu.kh.yummy.member.model.vo.Member;

@WebServlet("/faq2/*")
public class Faq2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();          
		String contextPath = request.getContextPath(); 
		String command = uri.substring( (contextPath + "/faq2/").length() );
		
		String path = null; 
		RequestDispatcher view = null; 
		
		String icon = null;
		String title = null;
		String text = null;
		
		HttpSession session = request.getSession();
		
		try {
			
			Faq2Service service = new Faq2Service();
			
			// 현재 페이지
			int cpage = request.getParameter("cpage") == null? 1 : Integer.parseInt( request.getParameter("cpage") );
			
			if(command.equals("viewFaq")) {
				
				path = "/WEB-INF/views/faq/faqInsert.jsp";
				
				view = request.getRequestDispatcher(path);
				
				view.forward(request, response);
				
			}
			else if(command.equals("insertFaq")) {
				
				String faqTitle = request.getParameter("faqTitle");
				String faqContent = request.getParameter("faqContent");
				int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
				
				Faq faq = new Faq(faqTitle,faqContent, memberNo);
				
				int result = service.insertFaq(faq);
				
				if(result > 0) {  
					icon = "success";
					title = "faq 등록 성공";
					path = "../faq/detail?no=" + result + "&cpage=1";
				}else { 
					icon = "error";
					title = "faq 등록 실패";
					
					path = request.getHeader("referer");
				}
				
				
				// 2) 메세지들을 Session에 추가
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				
				// 3) 마이페이지 재요청
				response.sendRedirect(path);
				
			// faq 삭제	
			}else if(command.equals("deleteFaq")) {
				
				int faqNo = Integer.parseInt(request.getParameter("no"));
				
				// System.out.println(faqNo);
				
				
				int result = service.deleteFaq(faqNo);
				
				if(result > 0) {
					icon = "success";
					title = "FAQ 삭제 성공";
					path = "../faq/list?&cpage=" + cpage; 
							
				}else {
					icon = "error";
					title = "FAQ 삭제 실패";
					path = "../faq/list?&cpage=" + cpage; 
				}
				
				
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				
				response.sendRedirect(path);
				
			// faq 수정 화면으로 보여주기
			}else if(command.equals("updateView")) {
				
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				
				Faq faq = new SelectFaqService().selectFaq(faqNo);
				
				faq.setFaqContent(faq.getFaqContent().replaceAll("<br>", "\r\n"));
				
				request.setAttribute("faq", faq);
				
				path = "/WEB-INF/views/faq/faqUpdate.jsp";
				
				view = request.getRequestDispatcher(path);
				
				view.forward(request, response);
				
			}else if(command.equals("updateFaq")) {
				
				int faqNo = Integer.parseInt(request.getParameter("faqNo"));
				String faqTitle = request.getParameter("faqTitle");
				String faqContent = request.getParameter("faqContent");
				
				Faq faq = new Faq();
				faq.setFaqNo(faqNo);
				faq.setFaqTitle(faqTitle);
				faq.setFaqContent(faqContent);
				
				cpage = Integer.parseInt(request.getParameter("cpage"));
				
				int result = service.updateFaq(faq);
				
				if(result > 0) {
					icon = "success";
					title="faq 수정 성공";
					path = "../faq/detail?no=" + faqNo + "&cpage="+cpage;
				}else {
					icon = "error";
					title = "faq 수정 실패";
					path = "../faq/list?&cpage=" + cpage; 
				}
				
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				
				response.sendRedirect(path);
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
