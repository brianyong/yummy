package edu.kh.yummy.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.kh.yummy.store.vo.Store;
import edu.kh.yummy.member.model.service.MemberService;
import edu.kh.yummy.member.model.vo.Member;
import edu.kh.yummy.order.model.service.OrdersService;
import edu.kh.yummy.order.model.vo.Orders;

@WebServlet("/order/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int memberNo = ((Member) session.getAttribute("loginMember")).getMemberNo();

		try {
			OrdersService service = new OrdersService();

			Orders orderInfo = service.orderInfo(memberNo);

			session.setAttribute("orderInfo", orderInfo);

			String path = "/WEB-INF/views/order/orderList.jsp";
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} catch (Exception e) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
