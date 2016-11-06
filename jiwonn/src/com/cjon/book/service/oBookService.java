package com.cjon.book.service;

import com.cjon.book.dao.BookDAO;

public class BookService {

	
	
	public String selectForPage(int page){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.selectForPage(page);
		
		return result;
		
	}
	

	public String getList(String keyword){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.select(keyword);
		
		return result;
		
	}
	
	public String userRentStatusList(String email, String userEmail){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.userRentStatusList(email,userEmail);
		
		return result;
		
	}
	
	//도서 대여 관리를 위한 전체 도서 리스트 출력
	public String getrbookList(String keyword, String userEmail){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.getrbookList(keyword,userEmail);
		
		return result;
		
	}
	
	//도서 대여 관리를 위한 도서 대여여부 업데이트
	public boolean updaterentbook(String keyword, String email){
			
			
		BookDAO dao = new BookDAO();
		boolean result = dao.updaterentbook(keyword,email);
		
		return result;
			
	}
	
	// 도서반납 하기  업데이트
		public boolean returnbookupdate(String keyword, String email){
				
				
			BookDAO dao = new BookDAO();
			boolean result = dao.returnbookupdate(keyword,email);
			
			return result;
				
		}
		
		
		
		
	
	public String getListOne(String keyword){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.selectOne(keyword);
		
		return result;
		
	}
	
	
	public String getListAll(String keyword){
		
		
		BookDAO dao = new BookDAO();
		String result = dao.selectAll(keyword);
		
		return result;
		
	}

	
	public boolean updateBook(String isbn,String price, String title, String author){
		BookDAO dao = new BookDAO();
		boolean result = dao.update(isbn,price,title,author);
		return result;
	}
	
	public boolean deleteBook(String isbn){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.delete(isbn);
		return result;
		
	}
	
	public boolean insertBook(String imgfile, String isbn, String bookprice, String booktitle,String bookauthor,String bookpub,String booktran){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.insert( imgfile,  isbn,  bookprice,  booktitle, bookauthor, bookpub, booktran);
		return result;
		
	}
	
	
	public boolean join(String name,String pass,String email){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.join(name,pass,email);
		return result;
		
	}
	
	
	public String selectOneMember(String email){
		
		BookDAO dao = new BookDAO();
		String result = dao.selectOneMember(email);
		return result;
		
	}
	
	public boolean logincheck(String email,String pass){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.logincheck(email,pass);
		return result;
		
	}
	
	public boolean commentInsert(String isbn, String title, String author, String pass,String email, String text, String content,String img){
		
		BookDAO dao = new BookDAO();
		boolean result = dao.commentInsert(isbn,title,author,pass,email,text,content,img);
		return result;
		
	}
	
	public String commentList(String reviewisbn){
		
		BookDAO dao = new BookDAO();
		String result = dao.commentList(reviewisbn);
		return result;
		
	}
	
	//서평 하나 출력하기
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
