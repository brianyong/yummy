package edu.kh.yummy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

	public void destroy() {
		// 필터 내용이 변경되어 이전 필터 내용이 필요 없어질 경우 수행
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터링 내용을 작성하는 메소드
		
		// 1. 요청 데이터의 문자 인코딩을 UTF-8로 변경
		request.setCharacterEncoding("UTF-8");
	
		// 2. 응답 데이터의 문자 인코딩을 UTF-8로 변경
		response.setCharacterEncoding("UTF-8");
		
		// 3. 연결된 필터가 있으면 다음 필터로 전달
		//    없으면 Servlet 또는 JSP로 전달
		chain.doFilter(request, response);
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// 서버 실행 시 필터 객체가 생성될 때의 동작을 지정
	}

}
