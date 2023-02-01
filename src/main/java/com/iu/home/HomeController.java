package com.iu.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("hello ggggga");
		
//		String method = request.getMethod();
//		StringBuffer sb = request.getRequestURL();
//		String uri = request.getRequestURI();
//		String context = request.getContextPath();
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		int a=0;
//		if(age != null) { //favicon 주소가 넘어감
//			a = Integer.parseInt(age);
//
//		}
//
//		
//		String [] moneys = request.getParameterValues("money");
//		
//		
//		Cookie [] cookies = request.getCookies();
//		if (cookies != null) {	//favicon 대응
//		for (Cookie cookie:cookies) {
//			System.out.println("cookie name:"+cookie.getName());
//			System.out.println("cookie value:"+cookie.getValue());
//			}
//		}
//		System.out.println("method: " + method);
//		System.out.println("url: " +sb);
//		System.out.println("uri: " + uri);
//		System.out.println("context: "+context);
//		System.out.println("name: "+name);
//		System.out.println("age: " + a);
//
//		
//		for (String m: moneys) {
//			System.out.println("money: "+ m);
//		}
		
//		//JSP가 변환시켜주지 않으면..
//		PrintWriter out = response.getWriter();	
//		out.println("<h1>HM PAGE</H1>");
//		out.println("<h2>header2</h2>");
//		out.close();

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
