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
@WebServlet("/commentContent")
public class CommentContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CommentContent() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 입력받고
		
		String cid = request.getParameter("cid");		
		String callback = request.getParameter("callback");
		
		System.out.println("서평 content 들어왔습니다다다");
		//2.로직처리
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		
		BookService service = new BookService();
		String result = service.commentContent(cid);
		
		
		
		//3.출력처리
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback+"("+result+")");
		out.flush();
		out.close();
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
