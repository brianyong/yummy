package edu.kh.yummy.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.vo.Member;
import edu.kh.yummy.notice.model.service.Notice2Service;
import edu.kh.yummy.notice.model.service.SelectNoticeService;
import edu.kh.yummy.notice.model.vo.Notice;

//로그인 요청 주소 : /yummy/notice2/
@WebServlet("/notice2/*")
public class Notice2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // URI : 식별 가능한 요청 주소. ex) /yummy/notice2/list
		String contextPath = request.getContextPath(); // 최상위 주소	   ex) /yummy
		String command = uri.substring( (contextPath + "/notice2/").length() ); // list
		// uri에서 contextPath + "/notice2/" 만큼을 앞에서부터 잘라낸 나머지를 command 저장
		
		String path = null; // 응답화면 주소 또는 경로
		RequestDispatcher view = null; // 요청 위임 객체 저장 참조 변수
		
		// sweetalert용 변수
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			Notice2Service service = new Notice2Service();
			
			// 현재 페이지 저장
			// 삼항 연산자를 이용해서 cp가 없으면 1, 있으면 int형태로 파싱한 cp값을 저장
			int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));
			// 헤더에 ${contextPath}/notice/noticeList에서 cp를 찾는데 없다
			// get방식이면 주소에 나타나서 주소에서 찾는거임
			
			// 게시글 등록 화면 전환 Controller
			if(command.equals("insertForm")) {
				
				path = "/WEB-INF/views/notice/noticeInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			// 게시글 삽입 Controller
			else if(command.equals("insert")) {
				
				String noticeTitle = request.getParameter("noticeTitle");
				String noticeContent = request.getParameter("noticeContent");
				HttpSession session = request.getSession();
				int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
				
				Notice notice = new Notice();
				notice.setNoticeTitle(noticeTitle);
				notice.setNoticeContent(noticeContent);
				notice.setMemberNo(memberNo);
				
				int result = service.insertNotice(notice);
				
				if(result > 0) {
					icon = "success";
					title = "게시글 등록 성공!";
					path = "../notice/view?no="+result+"&cp=1";
					
				}else {
					icon = "error";
					title = "게시글 등록 실패";
					
					// insertForm
					path = request.getHeader("referer");
				}
				
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
				
				
			}
			
			// 게시글 수정 화면 전환 Controller
			else if(command.equals("updateForm")) {
				// 게시글 수정 화면에 수정하려는 게시글의 내용이 미리 작성되어 있어야함.
				
				
				// 게시글 상세조회(게시글 번호 필요)
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				Notice notice = new SelectNoticeService().selectNotice(noticeNo);
				notice.setNoticeContent(notice.getNoticeContent().replaceAll("<br>", "\r\n"));
				
				request.setAttribute("notice", notice);
				
				path = "/WEB-INF/views/notice/noticeUpdate.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
					
				
			}
			
			// 공지사항 수정 Controller
			else if(command.equals("update")) {
				
				HttpSession session = request.getSession();
				
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				String noticeTitle = request.getParameter("noticeTitle");
				String noticeContent = request.getParameter("noticeContent");
				
				Notice notice = new Notice();
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(noticeTitle);
				notice.setNoticeContent(noticeContent);
				
				int result = service.updateNotice(notice);
				
				if(result > 0) {
					icon = "success";
					title = "공지사항 수정 성공";
					path = "../notice/view?no="+noticeNo+"&cp="+cp;
				}else {
					icon = "error";
					title = "공지사항 수정 실패";
					path = request.getHeader("referer");
				}
				
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
			}
			
			// 공지사항 삭제 Controller
			else if(command.equals("delete")) {
				
				HttpSession session = request.getSession();
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				

				int result = service.deleteNotice(noticeNo);
				
				if(result > 0){
					icon = "success";
					title = "공지사항 삭제 성공";
					path = "../notice/noticeList";
				}else {
					icon = "error";
					title = "공지사항 삭제 실패";
					path = request.getHeader("referer");
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
