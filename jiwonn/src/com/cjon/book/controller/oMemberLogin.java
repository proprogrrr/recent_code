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
@WebServlet("/bookLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MemberLogin() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 입력받고
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String callback = request.getParameter("callback");
		
		
		System.out.println("login으로 들어왔습니다다다");
		//2.로직처리
		
		BookService service = new BookService();
		boolean result = service.logincheck(email,pass);
		
		if(result) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
		} 
		
		//3.출력처리
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback+"("+result+")");
		out.flush();
		out.close();
		
		System.out.println(result+"로그인 후 ");
		
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
