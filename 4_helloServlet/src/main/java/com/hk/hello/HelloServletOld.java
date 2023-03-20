package com.hk.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServletOld extends HttpServlet{

//	@Override
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		super.init();
//	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//JSP에서 알던 그 application을 구한거임
		ServletContext application=config.getServletContext();
		//config로부터 파라미터 받는 방법
		System.out.println(config.getInitParameter("id"));
		//servletContext(application)로 부터 파라미터 받는 방법
		System.out.println("init()실행:servletContext값:"
							+application.getInitParameter("driver"));
	}
	
	public void testparam(HttpServletRequest req) {
//		HttpServletRequest request=new HttpSE // 자체적으로 생성해서 사용할 수 없음
		req.getParameter("name");//doGet,doPost로 부터 요청,응답 객체 받아서 처리
		
	}
	
	//service를 doGet과 doPost로 구현하였음
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식으로 요청");
		doPost(req, resp);//get방식으로 요청이 와도 doPost()를 호출하므로 doPost에 코드를 모두 작성하면됨
		testparam(req);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 파라미터가 한글일때 인코딩처리
		request.setCharacterEncoding("utf-8");
		//응답할때 브라우저에 표현할 한글 인코딩처리
		response.setContentType("text/html; charset=utf-8");
		//ServletContext(application)구하는 방법
		System.out.println(
		"application파람:"+request.getServletContext().getInitParameter("driver")
				);
		//session객체구하는 방법
		HttpSession session=request.getSession();
		
		//여기서 모든 코드를 작성하면 됨
		System.out.println("post방식으로 요청");
		
		//전달된 파라미터 받기
		System.out.println("전달받은파라미터:"+request.getParameter("name")); 
		
		System.out.println("context정보:"+request.getContextPath());
		System.out.println("pathInfo정보:"+request.getPathInfo());
		System.out.println("uri정보:"+request.getRequestURI());
		
		//요청에 대한 처리를 하고 브라우저로 응답하기
		//1. html을 출력해서 결과를 보여주는 방법[only servlet방식]
		//  --> 브라우저에 출력할 수 있는 프린터가 필요
		PrintWriter pw=response.getWriter();
		pw.print("<h1>HelloServlet</h1>");
		pw.print("<h2>[3대개념알아보기]</h2>");
		
		//2. 요청한 페이지로 이동시켜서 보여주는 방법
//		response.sendRedirect("index.jsp");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("더이상 요청이 없으면 서블릿을 소멸시킨다~~");
	}

}





