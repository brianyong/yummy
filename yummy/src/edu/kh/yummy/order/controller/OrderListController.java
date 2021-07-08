package edu.kh.yummy.order.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.Select;

import edu.kh.yummy.store.model.vo.Store;
import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;
import edu.kh.yummy.order.model.service.OrdersService;
import edu.kh.yummy.order.model.vo.Orders;
import edu.kh.yummy.order.model.vo.Pagination;

@WebServlet("/order/*") // order로 시작하는 요청을 모두 받음
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/order/").length());

		String path = null;
		RequestDispatcher view = null;
		String icon = null;
		String title = null;
		String text = null;

		try {
			OrdersService service = new OrdersService();

			// 현재 페이지
			int cp = request.getParameter("cp") == null ? 1 : Integer.parseInt(request.getParameter("cp"));

			if (command.equals("orderList")) {// 주문내역 조회 컨트롤러

				HttpSession session = request.getSession();

				int memberNo = ((Member) session.getAttribute("loginMember")).getMemberNo();

				// System.out.println(memberNo);

				Pagination pagination = service.getPagination(cp, memberNo);

				System.out.println(pagination);
				List<Map<String, Object>> orderList = service.orderListView(pagination, memberNo);
				System.out.println(orderList);

				request.setAttribute("pagination", pagination);
				request.setAttribute("orderList", orderList);

				path = "/WEB-INF/views/order/orderList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}
