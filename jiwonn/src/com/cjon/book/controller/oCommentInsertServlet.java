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
@WebServlet("/commentInsert")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CommentInsertServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 입력받고
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String pass = request.getParameter("pass");
		String text = request.getParameter("text");
		String content = request.getParameter("content");
		String img = request.getParameter("img");

		
		String callback = request.getParameter("callback");
		
		System.out.println("서평 인서트로 로 들어왔습니다다다");
		//2.로직처리
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		BookService service = new BookService();
		boolean result = service.commentInsert(isbn,title,author,pass,email,text,content,img);
		
		
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
