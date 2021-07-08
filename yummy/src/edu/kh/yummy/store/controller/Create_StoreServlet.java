package edu.kh.yummy.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.yummy.member.model.vo.Member;
import edu.kh.yummy.store.model.service.StoreService;
import edu.kh.yummy.store.model.vo.Store;


@WebServlet("/store/create_store")
public class Create_StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/store/create_store.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String b_Name = request.getParameter("b_name");
		String store_intro = request.getParameter("store_intro");
		String store_starttime = request.getParameter("store_starttime");
		String store_endtime = request.getParameter("store_endtime");
		
		String[] corp_num = request.getParameterValues("corp_num");
		String[] b_phone = request.getParameterValues("b_phone");
		 
		String corp_num_s = String.join("-", corp_num);
		String b_phone_s = String.join("-", b_phone);
		
		String category_detail[] = {"한식", "양식", "중식", "일식", "치킨/피자", "야식", "카페/디저트"};
		int category_n = 9;
		
		String category_sel = request.getParameter("category_sel");
		
		for (int i=0; i<7; i++) {
			if(category_sel.equals(category_detail[i])) {
				category_n = i+1;
				break;
			}
		}
		
		String[] address = request.getParameterValues("address");
		String b_Address = null;
		if(address != null) {
			b_Address = String.join(",", address);
		}
		
		String storeImg = "/resources/images/store/" + request.getParameter("storeImg");
		
		HttpSession session = request.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		

		// 파라미터를 하나의 객체에 담기
		Store store = new Store();
		store.setStoreName(b_Name);
		store.setCorNo(corp_num_s);
		store.setStorePhone(b_phone_s);
		store.setStoreOpen(store_starttime);
		store.setStoreClose(store_endtime);
		store.setStoreStory(store_intro);
		store.setCategoryNo(category_n);
		store.setStoreAddr(b_Address);
		store.setStoreImg(storeImg);
		
	      try {
	    	  
	    	 StoreService service = new StoreService(); 
	         
	         int result = service.Store(store, memberNo);
	         
	         String icon = null;
	         String title = null;
	         String text = null;
	         
	         if(result > 0) {
	        	 icon = "success";
	        	 title = "정보 등록 성공";
	        	 text = "가게 정보가 정상적으로 등록되었습니다.";
	         }else {
	        	 icon = "error";
	        	 title = "수정 중 문제 발생";
	        	 text = "문제가 지속될 경우 문의 바랍니다.";
	         }
	         
	         // session에 값 세팅
	         //HttpSession session = request.getSession();
	         session.setAttribute("icon", icon);
	         session.setAttribute("title", title);
	         session.setAttribute("text", text);
	         
	         // 메인 페이지로 돌아간다 -> redirect
	         // 메인 페이지를 응답하는 요청주소로 재요청하기
	         response.sendRedirect(request.getContextPath());
	         
	    	 
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      }
		
	}

}
