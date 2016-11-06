package com.cjon.book.service;

import com.cjon.book.dao.BookDAO;

public class BookService {

	// 리스트를 가져오는 일을 하는 method
	public String getList(String keyword) {
		// 일반적인 로직처리 나와요!!
		
		// 추가적으로 DB처리가 나올 수 있어요!
		// DB처리는 Service에서 처리는하는게 아니라..다른 객체를 이용해서
		// Database처리를 하게 되죠!!
		BookDAO dao = new BookDAO();
		String result = dao.select(keyword);	
		
		return result;
	}

	public String updateBook(String isbn, String title, String author, String price) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		String result = dao.update(isbn,title,author,price);	
		return result;
	}
	public boolean deleteBook(String isbn) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		boolean result = dao.deleteBook(isbn);	
		return result;
	}
	
	public String insertBook(String isbn, String img, String title, String author, String price) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		String result = dao.insertBook(isbn,img,title,author,price);	
		return result;
	}
	
	public String bookDetail(String isbn) {
		// TODO Auto-generated method stub
		System.out.println("in service : "+isbn);
		BookDAO dao = new BookDAO();
		String result = dao.info(isbn);	
		return result;
	}

    public Boolean insertMember(String id, String password, String email) {
		
		BookDAO dao = new BookDAO();
		boolean result = dao.insertMem(id,password,email);
		return result;
	}
	
    
	public String selectOneMember(String id){
		
		BookDAO dao = new BookDAO();
		String result = dao.selectOneMember(id);
		return result;
		
	}
    
    
    
    public Boolean login(String id, String password) {
		
		BookDAO dao = new BookDAO();
		boolean result = dao.login(id,password);
		return result;
	}

	public Boolean session(String id, String password) {
	
		BookDAO dao = new BookDAO();
		boolean result = dao.session(id,password);
		return result;
	}

	
    public boolean commentInsert(String isbn, String title, String author, String password, String id, String text, String content,String img){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.commentInsert(isbn,title,author,password,id,text,content,img);
		return result;
		
	}
	
	public String commentList(String reviewisbn){
		
		BookDAO dao = new BookDAO();
		String result = dao.commentList(reviewisbn);
		return result;
		
	}
	
public String commentContent(String cid){
		
		BookDAO dao = new BookDAO();
		String result = dao.commentContent(cid);
		return result;
		
	}
	
	public String commentKeywordList(String search){
		
		BookDAO dao = new BookDAO();
		String result = dao.commentKeywordList(search);
		return result;
		
	}
	
	public boolean deleteComment(String cid){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.deleteComment(cid);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}












