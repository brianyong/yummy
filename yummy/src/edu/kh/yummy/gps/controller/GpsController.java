package edu.kh.yummy.gps.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.yummy.gps.model.service.GpsService;
import edu.kh.yummy.store.model.vo.Store;

@WebServlet("/gps/*")
public class GpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String path = null; 
	RequestDispatcher view = null; 
	
	String icon = null;
	String title = null;
	String text = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/gps/").length());
		
		try {
			
			GpsService service = new GpsService();
			
			if(command.equals("searchView")) {
			
				
				// 주소를 얻어옴
				String searchGps = request.getParameter("searchGps");
			
				
				request.setAttribute("searchGps", searchGps);
				path = "/WEB-INF/views/gps/gpsList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
				
			}else if(command.equals("search")) {
				
				String search = request.getParameter("searchGps");
				
				System.out.println(search);
				
				// '구'라는 단어가 어디에 있는지 확인
				int end = search.indexOf("구");
				
				// '구' 다음으로 나오는 주소들은 다 자름
				String subSearch = search.substring(0 , end+1);
				
				// 서울시 동대문구 -> 공백으로 구를 추출
				String[] gList = subSearch.split(" ");

				
				String searchGu = gList[1];
				
				System.out.println(searchGu);
				
				List<Store> sList = service.selectList(searchGu);
				
				Gson gson = new Gson();
				gson.toJson(sList, response.getWriter());
				
				
			}else if(command.equals("list")) {
				String searchGps = "current";
				
				request.setAttribute("searchGps", searchGps);
				path = "/WEB-INF/views/gps/gpsList.jsp";
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
