package edu.kh.yummy.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store/store")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/store/store.jsp");
	      
	      view.forward(request, response);
	      
	      request.setCharacterEncoding("UTF-8");
	      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
