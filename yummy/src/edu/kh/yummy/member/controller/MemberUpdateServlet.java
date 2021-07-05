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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");

		
		HttpSession session = request.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		int memberNo = loginMember.getMemberNo();// 회원번호
		
		String[] phone = request.getParameterValues("phone");
		String memberPhone = String.join("-", phone);
		String memberEmail = request.getParameter("email");
	
		try {

			// 4. 회원정보 수정 서비스를 호출 후 결과 반환받기 -> 결과가 int로 넘어올 것임
			int result = new MemberService().memberUpdate(memberPhone, memberEmail, memberNo);

			// 5. 수정 결과에 따라 화면에 SweetAlert로
			// 수정 성공/실패 메세지 출력하도록 session에 속성 세팅

			// 6.로그인된 회원 정보를 최신 버전으로 업데이트
			// 회원정보를 수정 성공했을때
			// Session에 있는 loginMember에 업데이트 성공한

			if (result > 0) { // 회원 업데이트 성공

				session.setAttribute("icon", "success"); // success, warning, error, info
				session.setAttribute("title", "회원 정보 업데이트 성공");
				session.setAttribute("text", "회원정보 업데이트에 성공 했습니다.");

				loginMember.setMemberPhone(memberPhone);
				loginMember.setMemberEmail(memberEmail);
				

			} else {
				session.setAttribute("icon", "error"); // success, warning, error, info
				session.setAttribute("title", "회원 정보 업데이트 실패");
				session.setAttribute("text", "회원정보 업데이트에 실패했습니다.");

			}

			// 7. 마이페이지로 재요청
			// 절대경로 response.sendRedirect(request.getContextPath()+"/member/myPage");
			response.sendRedirect("myPage");


		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMsg", "회원정보 수정 과정에서 오류 발생");

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
