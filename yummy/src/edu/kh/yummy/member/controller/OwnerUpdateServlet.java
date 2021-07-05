package edu.kh.yummy.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.category.model.vo.Store;
import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;



@WebServlet("/member/ownerupdate")
public class OwnerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		System.out.println("owerUpdate성공");
		HttpSession session = request.getSession();
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		Store storeInfo = (Store) session.getAttribute("storeInfo");
		
		int memberNo = loginMember.getMemberNo();
		
		// 3 부터 숙제 -> 파라미터로 전달받은 수정된 회원정보를 변수에 각각 저장
				// DB에 저장하기 위해 알맞은 형태로 변환 , 회원가입 Servlet 참고

		String[] phone = request.getParameterValues("phone");
		String[] storePhone = request.getParameterValues("storePhone");
		String memberPhone = String.join("-", phone);
		String storePhone1 = String.join("-", storePhone);
		String memberEmail = request.getParameter("email");
		String[] address = request.getParameterValues("storeAddr");
		

		
		String storeAddr = null;
		if (address != null) {
			storeAddr = String.join(",", address);
		}
		
		try {
			int result = new MemberService().ownerUpdate(memberPhone, memberEmail, storeAddr, storePhone1, memberNo);
			
			// 5. 수정 결과에 따라 화면에 SweetAlert로
						// 수정 성공/실패 메세지 출력하도록 session에 속성 세팅
						
						
						// 6.로그인된 회원 정보를 최신 버전으로 업데이트
						// 회원정보를 수정 성공했을때 
						// Session에 있는 loginMember에 업데이트 성공한 

						if (result > 0) { // 회원 가입 성공

							session.setAttribute("icon", "success"); // success, warning, error, info
							session.setAttribute("title", "회원 정보 업데이트 성공");
							session.setAttribute("text", "회원정보 업데이트에 성공 했습니다.");

							loginMember.setMemberPhone(memberPhone);
							loginMember.setMemberEmail(memberEmail);
							storeInfo.setStoreAddr(storeAddr);
							storeInfo.setStorePhone(storePhone1);
							
						} else {
							session.setAttribute("icon", "error"); // success, warning, error, info
							session.setAttribute("title", "회원 정보 업데이트 실패");
							session.setAttribute("text", "회원정보 업데이트에 실패했습니다.");

						}
						
					

						// 7. 마이페이지로 재요청
						//절대경로  response.sendRedirect(request.getContextPath()+"/member/myPage");
						response.sendRedirect("ownerMyPage");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
