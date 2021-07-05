package edu.kh.yummy.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.yummy.notice.model.service.SelectNoticeService;
import edu.kh.yummy.notice.model.vo.Notice;
import edu.kh.yummy.notice.model.vo.Pagination;

// 요청 주소 : /yummy/notice/noticeList
@WebServlet("/notice/*")
public class SelectNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // URI : 식별 가능한 요청 주소. ex) /yummy/notice/noticeList
		String contextPath = request.getContextPath(); // 최상위 주소	   ex) /yummy
		String command = uri.substring( (contextPath + "/notice/").length() ); // noticeList
		// uri에서 contextPath + "/board/" 만큼을 앞에서부터 잘라낸 나머지를 command 저장
		
		String path = null; // 응답화면 주소 또는 경로
		RequestDispatcher view = null; // 요청 위임 객체 저장 참조 변수
		
		// sweetalert용 변수
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			SelectNoticeService service = new SelectNoticeService();
			
			// 현재 페이지 저장
			// 삼항 연산자를 이용해서 cp가 없으면 1, 있으면 int형태로 파싱한 cp값을 저장
			int cp = request.getParameter("cp") == null ? 1 
					: Integer.parseInt(request.getParameter("cp"));
			// 헤더에 ${contextPath}/notice/list?type=1에서 cp를 찾는데 없다
			// get방식이면 주소에 나타나서 주소에서 찾는거고
			// jsp에 있음 
			
			// 게시글 목록 조회 Controller
			if(command.equals("noticeList")) {
				
				// 페이징 처리를 위한 여러 정보를 담고있는 객체 Pagination 생성
				Pagination pagination = service.getPagination(cp);
				
				List<Notice> noticeList = service.selectNoticeList(pagination);
				
				// pagination, noticeList를 request에 속성으로 추가한 후 noticeList.jsp로 forward
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("noticeList", noticeList);
				
				path = "/WEB-INF/views/notice/noticeList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				

			}
			
			// 게시글 상세 조회 Controller
			else if(command.equals("view")) {
				
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				
				Notice notice = service.selectNotice(noticeNo);
				
				request.setAttribute("notice", notice);
				
				path = "/WEB-INF/views/notice/noticeView.jsp";
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
