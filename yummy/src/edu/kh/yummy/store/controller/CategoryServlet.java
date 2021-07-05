package edu.kh.yummy.store.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.kh.yummy.store.model.service.CategoryService;
import edu.kh.yummy.store.model.vo.Store;

@WebServlet("/category/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/store/category.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			CategoryService service = new CategoryService();

			// String categoryNo = request.getParameter("categoryNo");
			int categoryNo = request.getParameter("categoryNo") == null ? 1 : Integer.parseInt(request.getParameter("categoryNo"));

			// System.out.println(categoryNo);
			// 값 잘 가져오는 중 ...

			List<Map<String, Object>> list = service.storeView(categoryNo);
			
			// JSON 데이터 반환하기
			new Gson().toJson(list, response.getWriter());
			// -> list를 JSON 형태로 변환하여 연결된 응답용 스트림을 이용해 출력
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
