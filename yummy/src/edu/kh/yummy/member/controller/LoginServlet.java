package edu.kh.yummy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
	      
	      view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 요청 시 전달 받은 파라미터를 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String saveId = request.getParameter("saveId");
		
		try {
			
			// 로그인 Service를 위한 MemberService 객체 생성
			MemberService service = new MemberService();
			
			// 로그인 요청을 처리할 수 있는 서비스 메소드를 호출하고 로그인 결과를 반환 받음.
			Member loginMember = service.login(memberId, memberPw);
			
			// 세션을 얻어와 변수에 저장
			HttpSession session = request.getSession();
			
			
			
			// 서비스 수행 결과에 따른 View 연결 처리
			if(loginMember != null) { // 로그인 성공
				
				String name = loginMember.getMemberName();
				
				session.setAttribute("title", name + "님 환영합니다!");
				
				// session에 로그인 정보 추가
				session.setAttribute("loginMember", loginMember);
				
				// 일정 시간 후 세션 만료
				// 30분 후
				session.setMaxInactiveInterval(1800); // 초 단위로 작성
				
				Cookie cookie = new Cookie("saveId", memberId);
				
				// 아이디 저장이 체크된 경우
				if(saveId != null) {
					
					// 쿠키 만료 기간을 설정
					// 일주일
					cookie.setMaxAge(60*60*24*7); 
					// 초 단위로 작성
					
				}else {
					// 아이디 저장이 체크되지 않은 경우 아이디가 저장된 쿠키 제거
					cookie.setMaxAge(0); 
					// 만료 기간 0초 == 쿠키 제거
				}
				
				// 쿠기가 사용될 수 있는 유효한 경로(디렉토리 또는 주소)를 설정
				cookie.setPath(request.getContextPath());
				// 해당 경로 및 하위 모든 경로에서 saveId 쿠키를 사용할 수 있음.
				
				// response에 Cookie를 담아서 클라이언트로 전달
				response.addCookie(cookie);
				
			}else { // 로그인 실패
				
				session.setAttribute("icon", "error"); // success, warning, error, info
				session.setAttribute("title", "로그인 실패");
				session.setAttribute("text", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
			}
			
			
			// 로그인을 성공하든, 실패하든 메인페이지로 이동하기
			response.sendRedirect( request.getContextPath()  );
			// request.getContextPath() : 프로젝트 최상위 주소 (/)
			
			System.out.println(loginMember);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
