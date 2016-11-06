package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjon.book.service.BookService;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/sessionCheck")
public class SessionCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SessionCheck() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 입력받고
		String callback = request.getParameter("callback");
		String check = request.getParameter("quit");
		
		System.out.println("세션체크하러 들어왔ㅆ스빈다.");

		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		
		if(check!=null){
			if(check.equals("t")){
				session.invalidate();
				System.out.println("세션을 만료시킵니다 안녕~~~~~");
			}
		}
		
		
		boolean result = true;
		
		if(email !=null){
			result = true;
			System.out.println("세션 이 존재합니다/");
		}else{
			result = false;
			System.out.println("세션이없습니다./");
		}
		
		
		//3.출력처리
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback+"("+result+")");
		out.flush();
		out.close();
		
		System.out.println(result+"세션 후후후후~ ");
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
