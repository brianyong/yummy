package edu.kh.yummy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.service.MemberService;

@WebServlet("/member/idDupCheck")
public class idDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/idDupCheck.jsp");
		
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		try {
			// DB에서 아이디 중복 검사 수행 후 결과를 반환받아 저장
			int result = new MemberService().idDupCheck(id);
			
			// 응답을 받을 클라이언트와의 연결 스트림
			PrintWriter out = response.getWriter();
			out.print(result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
