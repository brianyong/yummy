package edu.kh.yummy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.store.vo.Store;
import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;




@WebServlet("/member/ownerMyPage")
public class OwnerMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();		
		
		try {
			MemberService service = new MemberService();
			
			
			Store storeInfo = service.storeInfo(memberNo);
			
			session.setAttribute("storeInfo", storeInfo);
	
        String path = "/WEB-INF/views/member/ownerMyPage.jsp";
        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);
		}catch(Exception e) {
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
