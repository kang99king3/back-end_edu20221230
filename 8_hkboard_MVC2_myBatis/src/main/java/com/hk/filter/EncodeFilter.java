package com.hk.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class EncodeFilter extends HttpFilter implements Filter {

	private String encode;

	public void init(FilterConfig fConfig) throws ServletException {
		encode=fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			             FilterChain chain) throws IOException, ServletException {
		// place your code here
		//요청 파라미터가 한글일때 인코딩처리
		request.setCharacterEncoding("utf-8");
		//응답할때 브라우저에 표현할 한글 인코딩처리
		response.setContentType("text/html; charset=utf-8");
		
		//요청시 코드 작성
		System.out.println("요청코드");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("응답코드");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
