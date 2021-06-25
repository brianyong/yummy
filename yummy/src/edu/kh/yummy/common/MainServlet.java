package edu.kh.yummy.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메인 페이지 요청이 왔을 경우 index.jsp로 요청 위임
				RequestDispatcher view 
					= request.getRequestDispatcher("/WEB-INF/views/main.jsp");
				
				//요청 위임되는 jsp 파일의 경로는 WebContent를 기준으로 작성한다.
				
				//요청 위임 객체를 이용하여 request,response 객체를 jsp로 전송
				view.forward(request,response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
