package edu.kh.yummy.menu.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.vo.Member;
import edu.kh.yummy.menu.model.dao.MenuDAO;
import edu.kh.yummy.menu.model.service.MenuService;
import edu.kh.yummy.menu.model.vo.Menu;

// 메뉴 수정 서블릿 주소 
@WebServlet("/menu/*")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // URI : 식별 가능한 요청 주소. ex) /yummy/menu/menu
		String contextPath = request.getContextPath(); // 최상위 주소	   ex) /yummy
		String command = uri.substring( (contextPath + "/menu/").length() ); // menuUpdate
		// uri에서 contextPath + "/menu/" 만큼을 앞에서부터 잘라낸 나머지를 command 저장
		
		String path = null; // 응답화면 주소 또는 경로
		RequestDispatcher view = null; // 요청 위임 객체 저장 참조 변수
		
		// sweetalert용 변수
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			MenuService service = new MenuService();
			
		//	int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));
			
			// 메뉴 정보 조회 Controller
			if(command.equals("menuList")) {
				
				
				HttpSession session = request.getSession();
				int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
				List<Menu> menuList = service.selectMenuList(memberNo);
					
				request.setAttribute("menuList", menuList);
				
				path = "/WEB-INF/views/menu/menuUpdate.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			/*
			 * // 메뉴 수정 화면 전환 Controller else if(command.equals("updateForm")) {
			 * 
			 * // Board board = new SelectBoardService().selectBoard(boardNo); int menuNo =
			 * Integer.parseInt(request.getParameter("menuNo")); Menu menu =
			 * service.selectMenuList(memberNo);
			 * 
			 * path = "/WEB-INF/views/menu/menuUpdate.jsp"; view =
			 * request.getRequestDispatcher(path); view.forward(request, response);
			 * 
			 * }
			 */
			
			// 메뉴 수정 Controller
			else if(command.equals("menuUpdate")) {
				
				HttpSession session = request.getSession();
				
				int menuNo = Integer.parseInt(request.getParameter("menuNo"));
				String menuName = request.getParameter("menuName");
				int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
				int menuSalePercent = Integer.parseInt(request.getParameter("menuSalePercent"));
				String menuImg = "resources/images/menu/"+request.getParameter("menuImg");
				
				
				
				Menu menu = new Menu();
				menu.setMenuNo(menuNo);
				menu.setMenuName(menuName);
				menu.setMenuPrice(menuPrice);
				menu.setMenuSalePercent(menuSalePercent);
				menu.setMenuImg(menuImg);
				
				int result = service.updateMenu(menu);
				
				if(result > 0) {
					icon = "success";
					title = "메뉴 수정 성공";

				}else {
					icon = "error";
					title = "메뉴 수정 실패";

				}
				
				path = "menuList";
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
				
			}
			// 메뉴 삭제 Controller
			else if(command.equals("menuDelete")) {
				
				HttpSession session = request.getSession();
				int menuNo = Integer.parseInt(request.getParameter("menuNo"));
				
				int result = service.deleteMenu(menuNo);
				
				if(result > 0) {
					icon = "success";
					title = "메뉴 삭제 성공";
				}else {
					icon = "error";
					title = "메뉴 삭제 실패";
					
				}
				path = "menuList";
				session.setAttribute("icon", icon);
				session.setAttribute("title", title);
				response.sendRedirect(path);
				
			}
			
			// 메뉴 등록 화면 전환 Controller
			else if(command.equals("insertForm")) {
				
				path = "/WEB-INF/views/menu/menuInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
							
				
			}
			
			// 메뉴 등록 Controller
			else if(command.equals("menuInsert")) {
				
				String menuName = request.getParameter("menuName");
				int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
				int menuSalePercent = Integer.parseInt(request.getParameter("menuSalePercent"));
				String menuImg = "resources/images/menu/"+request.getParameter("menuImg");
				HttpSession session = request.getSession();
				int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
				int storeNo = ((Member)session.getAttribute("loginMember")).getStoreNo();
				
				Menu menu = new Menu();
				menu.setMenuName(menuName);
				menu.setMenuPrice(menuPrice);
				menu.setMenuSalePercent(menuSalePercent);
				menu.setMenuImg(menuImg);
				menu.setMemberNo(memberNo);
				menu.setStoreNo(storeNo);
				
				int result = service.insertMenu(menu);
				
				if(result > 0) {
					icon = "success";
					title = "메뉴 등록 성공!";
					path = "menuList";

				}else {
					icon = "error";
					title = "메뉴 등록 실패";
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
