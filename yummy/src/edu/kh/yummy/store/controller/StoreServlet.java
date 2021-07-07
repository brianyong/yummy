package edu.kh.yummy.store.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.yummy.menu.model.vo.Menu;
import edu.kh.yummy.store.model.service.StoreService;
import edu.kh.yummy.store.model.vo.Store;

@WebServlet("/store/store")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		StoreService service = new StoreService();

		int storeNo = Integer.parseInt(request.getParameter("storeNo"));


		try {
			
			Store store = service.storeDetail(storeNo);
			List<Menu> list = service.storeMenu(storeNo);
		
			request.setAttribute("store", store);
			request.setAttribute("list", list);
			System.out.println(list);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/store/store.jsp");

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
