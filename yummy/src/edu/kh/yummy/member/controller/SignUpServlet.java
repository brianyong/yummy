package edu.kh.yummy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;

// 회원가입 요청 주소: /yummy/member/signUp
@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 전달받은 파라미터를 모두 변수에 저장
		String memberName = request.getParameter("name");
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pwd1");
		String memberEmail = request.getParameter("email");
		String memberGrade = request.getParameter("grade");
	
		// 같은 name 속성으로 전달된 파라미터를 얻어옴
		String[] phone = request.getParameterValues("phone");
		
		// DB 저장을 위해 구분자 '-'를 이용하여 하나의 문자열로 합침
		String memberPhone = String.join("-", phone);
		
		// 파라미터를 하나의 Member객체에 담기
		Member member = new Member(memberName, memberId, memberPw, memberPhone, memberEmail, memberGrade);
	      
	      try {
	    	  
	    	 // 1) 회원가입 Service 호출 후 결과 반환 받기
	    	 MemberService service = new MemberService(); 
	         
	         int result = service.signUp(member);
	         
	         String icon = null;
	         String title = null;
	         String text = null;
	         
	         if(result > 0) {
	        	 icon = "success";
	        	 title = "환영합니다!";
	        	 text = "회원 가입이 완료되었습니다.";
	         }else {
	        	 icon = "error";
	        	 title = "가입 중 문제가 발생되었습니다.";
	        	 text = "문제가 지속될 경우 문의 바랍니다.";
	         }
	         
	         // session에 값 세팅
	         HttpSession session = request.getSession();
	         session.setAttribute("icon", icon);
	         session.setAttribute("title", title);
	         session.setAttribute("text", text);
	         
	         // 메인 페이지를 응답하는 요청주소로 재요청하기
	         response.sendRedirect(request.getContextPath());
	         
	    	 
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	         // 응답화면에 어떤 서비스 이용 과정에 오류 발생했다는 메세지 출력
	         
//	         request.setAttribute("errorMsg", "회원 가입 과정에서 문제가 발생하였습니다.");
	         
//	         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
	         
//	         view.forward(request, response);
	      }
		
	}

}
