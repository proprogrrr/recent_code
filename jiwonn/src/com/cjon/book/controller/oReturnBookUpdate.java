package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjon.book.service.BookService;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/returnbookupdate")
public class ReturnBookUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ReturnBookUpdate() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력받고
		
				
				String keyword = request.getParameter("keyword");
				String email = request.getParameter("email");

				String callback = request.getParameter("callback");
				
				System.out.println(email+"반납  업데이트에서 email 무슨값 들어오니======");
				System.out.println(keyword+"키워드닷");
				//2.로직처리
			
				BookService service = new BookService();
				boolean result = service.returnbookupdate(keyword,email);
				
				//3.출력처리
				response.setContentType("text/plain; charset=utf8");
				PrintWriter out = response.getWriter();
				out.println(callback+"("+result+")");
				out.flush();
				out.close();
	
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
