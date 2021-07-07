package edu.kh.yummy.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.cart.model.vo.Cart;

// 장바구니 서블릿 주소
@WebServlet("/cart/*")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // URI : 식별 가능한 요청 주소. ex) /yummy/cart/cart
		String contextPath = request.getContextPath(); // 최상위 주소	   ex) /yummy
		String command = uri.substring( (contextPath + "/cart/").length() ); // cart
		
		String path = null; // 응답화면 주소 또는 경로
		RequestDispatcher view = null; // 요청 위임 객체 저장 참조 변수
		
		try {
			List<Cart> cartList = (List<Cart>)request.getSession().getAttribute("cartList");
					
			
			// 장바구니 화면 전환 Controller
			if(command.equals("cart")) {
				
				
				int storeNo = Integer.parseInt(request.getParameter("storeNo"));
				int menuNo = Integer.parseInt(request.getParameter("menuNo"));
				String storeName = request.getParameter("storeName");
				String menuName = request.getParameter("menuName");
				int menuSaleCost = Integer.parseInt(request.getParameter("menuSaleCost"));
				int menuAmount = Integer.parseInt(request.getParameter("menuAmount"));
		
				
				
				Cart cart = new Cart();
				
				cart.setStoreNo(storeNo);
				cart.setMenuNo(menuNo);
				cart.setStoreName(storeName);
				cart.setMenuName(menuName);
				cart.setMenuSaleCost(menuSaleCost);
				cart.setMenuAmount(menuAmount);
				
				HttpSession session = request.getSession();
				session.setAttribute("cartList", cartList);
				

				cartList.add(cart);
				

				request.setAttribute("storeName", storeName);
				path = "/WEB-INF/views/cart/cart.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);				
				
				
			// 메뉴 삭제 Controller
			} else if(command.equals("deleteCart")){
				
				int menuNo = Integer.parseInt(request.getParameter("menuNo"));
				
				int index = -1;
				
				for( Cart cart : cartList) {
					
					if(cart.getMenuNo() == menuNo) {
						// 해당 menuNo가 존재하는 cart의 인덱스값
						index = cartList.indexOf(cart);
						System.out.println(index);
						System.out.println(menuNo);
					}else {
						index = -1;
					}
					
				}
				
				if(index > -1){
					cartList.remove(index);
				}else {
					System.out.println("일치하는 메뉴 없음");
				}
				
				path = "/WEB-INF/views/cart/cart.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);	
				
			// 주문하기로 이동하는 Controller
			}else if(command.equals("orderCart")) {
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
