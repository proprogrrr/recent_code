package com.cjon.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.cjon.book.common.DBTemplate;

public class BookDAO {

	//페이징 처리를 위한 함수!!!
	public String selectForPage(int page){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmtcount = null;
		ResultSet rscount = null;

		String result = null;
		String sql = null;
		double count =0;
		
		int pageCal = 0;
		
		try {
			System.out.println("페이지 처리 하러  들어왔습니당!!!");
			System.out.println("페이지 번호입니닷 :   "+page);
			//전체 데이터가 얼마나 되지는 count// 확인하고!
			sql = "select count(*) from book";
			pstmtcount = con.prepareStatement(sql);
			rscount = pstmtcount.executeQuery();
			while(rscount.next()){
				count = rscount.getInt(1);
			}
			
			double count1 = Math.ceil(count/12);
			count = (int) Math.ceil(count/12);
			
			pageCal = 12*page-12;
			
			
			
			
			System.out.println(count1+"count1 올림 값 출력");
			
			System.out.println(count+"count 올림 값 출력");

				sql = "select bisbn,bimgurl, btitle, bauthor, bprice from book limit ?, 12 ";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pageCal);
				rs = pstmt.executeQuery();			
			
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("img", rs.getString("bimgurl"));
				obj.put("title", rs.getString("btitle"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("price", rs.getString("bprice"));
				obj.put("count", count);
				obj.put("pageCal", pageCal);
				obj.put("page", page);
				arr.add(obj);
				System.out.println(rs.getString("bisbn"));

			}
			
			result = arr.toJSONString();
			
			System.out.println("전체리스트 및 페이징 처리 여기서 합니다==================================");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	
	
	
	
	
	
	
	public String select(String keyword){
			
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		
		try {
			String sql = "select bisbn,bimgurl, btitle, bauthor, bprice from book where btitle like ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("img", rs.getString("bimgurl"));
				obj.put("title", rs.getString("btitle"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("price", rs.getString("bprice"));
				arr.add(obj);
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("여기입니다...");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	public String selectOne(String keyword){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		System.out.println(keyword+"selectOne으로 들어옴");
		try {
			String sql = "select bisbn, btitle, bdate, bpage, bprice,bauthor,btranslator,bsupplement,bpublisher,bimgurl from book where bisbn = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,keyword);
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("title", rs.getString("btitle"));
				obj.put("date", rs.getString("bdate"));
				obj.put("page", rs.getString("bpage"));
				obj.put("price", rs.getString("bprice"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("translator", rs.getString("btranslator"));
				obj.put("supplement", rs.getString("bsupplement"));
				obj.put("publisher", rs.getString("bpublisher"));
				obj.put("img", rs.getString("bimgurl"));

				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));
				System.out.println(rs.getString("bpublisher"));
				System.out.println(rs.getString("bsupplement"));
			}
			result = arr.toJSONString();
			
			System.out.println("selectone으로 들어왔습니다...");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	public String selectAll(String keyword){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		
		try {
			String sql = "select bisbn, btitle, bdate, bpage, bprice,bauthor,btranslator,bsupplement,bpublisher,bimgurl from book where btitle like ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("title", rs.getString("btitle"));
				obj.put("date", rs.getString("bdate"));
				obj.put("page", rs.getString("bpage"));
				obj.put("price", rs.getString("bprice"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("translator", rs.getString("btranslator"));
				obj.put("supplement", rs.getString("bsupplement"));
				obj.put("publisher", rs.getString("bpublisher"));
				obj.put("img", rs.getString("bimgurl"));

				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));
				System.out.println(rs.getString("bpublisher"));
				System.out.println(rs.getString("bsupplement"));
			}
			result = arr.toJSONString();
			
			System.out.println("여기입니다...");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	
	
	public boolean update(String isbn,String price, String title, String author){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;

		boolean result = false;
		
		try {
			String sql = "update book set btitle=?, bprice=?, bauthor=? where bisbn = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, Integer.parseInt(price));
			pstmt.setString(3, author);
			pstmt.setString(4, isbn);

			
			int count = pstmt.executeUpdate();
			//결과값은 영향을 받은 레코드의 수

			if(count==1){
				result = true;
				DBTemplate.commit(con);
				
			}else{
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	

	public boolean delete(String isbn){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;

		boolean result = false;
		
		try {
			String sql = "delete from book where bisbn = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			int count = pstmt.executeUpdate();
			//결과값은 영향을 받은 레코드의 수
				
			
			if(count==1){
				result = true;
				DBTemplate.commit(con);
				
			}else{
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	public boolean insert(String imgfile, String isbn, String bookprice, String booktitle,String bookauthor,String bookpub,String booktran){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;

		boolean result = false;
		
		try {
			
			String sql = "insert into book (bisbn, btitle,bprice,bauthor,btranslator, bpublisher,bimgbase64) values ( ?,?,?,?,?,?,? )"; 

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, booktitle);
			pstmt.setString(3, bookprice);
			pstmt.setString(4, bookauthor);
			pstmt.setString(5, booktran);
			pstmt.setString(6, bookpub);
			pstmt.setString(7, imgfile);

			int count = pstmt.executeUpdate();
			//결과값은 영향을 받은 레코드의 수
			
			if(count==1){
				result = true;
				DBTemplate.commit(con);
			System.out.println("인서트가 완료되었다 시발!!!");	
			}else{
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	public boolean join(String name, String email,String pass){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(pass);
		
		boolean result = false;
		
		try {
			
			String sql = "insert into book_member (member_name, member_email, member_pass) values (?,?,?)"; 
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);

			int count = pstmt.executeUpdate();
			//결과값은 영향을 받은 레코드의 수
			
			if(count==1){
				result = true;
				DBTemplate.commit(con);
			System.out.println("회원가입 인서트가 완료되었다 시발!!!");	
			}else{
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	

	public String selectOneMember(String keyword){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		System.out.println(keyword+"selectOne으로 들어옴");
		try {
			String sql = "select * from book_member where member_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,keyword);
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("email", rs.getString("member_email"));
				arr.add(obj);
			}
			if(rs!=null){
				result = arr.toJSONString();

			}
			if(rs==null){
				result = "";
			}
			System.out.println("중복검사하러 왔습니다.....");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		return result;
	}	
	

	public boolean logincheck(String email,String pass){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String pass1 = null;
		
		System.out.println(email+"logincheck로 들어옴");
		try {
			String sql = "select * from book_member where member_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				pass1 = rs.getString("member_pass");
				
				if(rs!=null){
					//아이디가 존재하고 패스워드가 동일하면
					if(pass.equals(pass1)){
						result = true;
					System.out.println("로그인 성공이당");
					}
					//아이디가 존재하고 패스워드가 동일하지 않으면
					else{
						result = false;
						System.out.println("로그인 실패당");

					}
				}
				
				//아이디가 존재하지 않으면
				if(rs==null){
					result = false;
					System.out.println("아이디가 존재하지않습니다");
				}
			}
			
			
			
			System.out.println("로그인 체크하러 왔습니다.......");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		return result;
	}	
	
	
	
	public boolean commentInsert(String isbn, String title, String author, String pass,String email, String text, String content,String img){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;

		boolean result = false;
		System.out.println(isbn +"dao에서 isbn 체크");
		System.out.println(title +"dao에서 isbn 체크");
		try {
			
			String sql = "insert into books_comment(bisbn,ctitle,cauthor,cdate,ctitle2,ctext,member_email,cpass,cimg) values(?,?,?,now(),?,?,?,?,?)"; 

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, text);
			pstmt.setString(5, content);
			pstmt.setString(6, email);
			pstmt.setString(7, pass);
			pstmt.setString(8, img);
			int count = pstmt.executeUpdate();
			//결과값은 영향을 받은 레코드의 수
			
			
			if(count==1){
				result = true;
				DBTemplate.commit(con);
			System.out.println("서평 ~~~~ 인서트가 완료되었다 시발!!!");	
			}else{
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}		
		
		return result;
		
	}	
	
	public String commentList(String reviewisbn){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = null;
		System.out.println("여기로 들어왔음");
		
		try {
			
			System.out.println(reviewisbn+"리뷰리스트 보기");
			
			if(reviewisbn==null){

				sql = "select * from books_comment order by cid desc";
				pstmt = con.prepareStatement(sql);


			}else{
				
				sql = "select * from books_comment where bisbn = ? order by cid desc";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, reviewisbn);
			}

			
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("ctitle", rs.getString("ctitle"));
				obj.put("cauthor", rs.getString("cauthor"));
				obj.put("cdate", rs.getString("cdate"));
				obj.put("ctitle2", rs.getString("ctitle2"));
				obj.put("ctext", rs.getString("ctext"));
				obj.put("email", rs.getString("member_email"));
				obj.put("cpass", rs.getString("cpass"));
				obj.put("cid", rs.getString("cid"));
				obj.put("img", rs.getString("cimg"));
				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("여기입니다...");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	//키워드 검색하면 ~~~~!~!~!~!~!~!~!~!~!~!~!~!~!~ 도서명으로 확인
		public String commentKeywordList(String search){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = null;
		System.out.println("여기로 들어왔음");
		
		try {
			
			System.out.println(search+"리뷰리스트 보기=--------------------------------------------");
			
		
				sql = "select * from books_comment where ctitle like ? order by cid desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+search+"%");

			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			
			System.out.println("0000000000000000000000000000000000000000000000000000000000000000");
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("ctitle", rs.getString("ctitle"));
				obj.put("cauthor", rs.getString("cauthor"));
				obj.put("cdate", rs.getString("cdate"));
				obj.put("ctitle2", rs.getString("ctitle2"));
				obj.put("ctext", rs.getString("ctext"));
				obj.put("email", rs.getString("member_email"));
				obj.put("cpass", rs.getString("cpass"));
				obj.put("cid", rs.getString("cid"));
				obj.put("img", rs.getString("cimg"));
				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("키워드로 검색한 서평 검색리스트 검색이 완료되었습니다.....");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	
	
	
	public String commentContent(String cid){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String sql = "select * from books_comment where cid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			System.out.println("안녕하세요오오오오오오오옹오오오오오");
			while(rs.next()){
				
				
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("ctitle", rs.getString("ctitle"));
				obj.put("cauthor", rs.getString("cauthor"));
				obj.put("cdate", rs.getString("cdate"));
				obj.put("ctitle2", rs.getString("ctitle2"));
				obj.put("ctext", rs.getString("ctext"));
				obj.put("email", rs.getString("member_email"));
				obj.put("cpass", rs.getString("cpass"));
				obj.put("cid", rs.getString("cid"));
				obj.put("img", rs.getString("cimg"));

				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("여기입니다...");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	
	public boolean deleteComment(String cid){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String sql = "delete from books_comment where cid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			int count = pstmt.executeUpdate();
			
			if(count==1){
				result = true;
				DBTemplate.commit(con);
				System.out.println("삭제성공했습니다.`!");	
			}else{
				DBTemplate.rollback(con);
			}
				System.out.println("삭제 실패했습니다아아아아아===========================");
				
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	

	
	public String getrbookList(String keyword,String userEmail){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		
		try {
			
			String sql = "select bisbn, rimg, rtitle,rauthor, rstatus, remail from rentreturn where rtitle like ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("rimg", rs.getString("rimg"));
				obj.put("rtitle", rs.getString("rtitle"));
				obj.put("rauthor", rs.getString("rauthor"));
				obj.put("rstatus", rs.getString("rstatus"));
				obj.put("remail", rs.getString("remail"));
				obj.put("userEmail", userEmail);
				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("도서 대여 반납 리스트 출력합니다===================================================");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	//유저의 대여상태를 확인 할 수 있는 함수!
	public String userRentStatusList(String email,String userEmail){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = null;
		
		try {
			
			if(email.equals("all")){
				
				sql = "select bisbn, rimg, rtitle,rauthor, rstatus, remail from rentreturn where rstatus = 1";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else{
				
				sql = "select bisbn, rimg, rtitle,rauthor, rstatus, remail from rentreturn where remail like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+email+"%");
				rs = pstmt.executeQuery();
			}
			
			JSONArray arr = new JSONArray();
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("rimg", rs.getString("rimg"));
				obj.put("rtitle", rs.getString("rtitle"));
				obj.put("rauthor", rs.getString("rauthor"));
				obj.put("rstatus", rs.getString("rstatus"));
				obj.put("remail", rs.getString("remail"));
				obj.put("userEmail", userEmail);
				arr.add(obj);
				
				System.out.println(rs.getString("bisbn"));

			}
			result = arr.toJSONString();
			
			System.out.println("도서 대여 반납 리스트 출력합니다===================================================");
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
		
	public boolean updaterentbook(String keyword,String email){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			
			String sql1 = "select * from rentreturn where remail=? and bisbn=?";
			
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, email);
			pstmt1.setString(2, keyword);
			rs = pstmt1.executeQuery();

			//대여한 도서가 있는 경우
			if(rs.next()){
				System.out.println("이미 대여한 도서가 있어서 대여가  불가 합니다=============================");
				result = false;
			}
			
			//대여한 도서가 없는 경우
			else{
				
				String sql = "update rentreturn set rstatus = 1, remail=? where bisbn =?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, keyword);
				
				System.out.println(email+" : "+ keyword + " 여기는 업데이트 부분=============");
				
				int count = pstmt.executeUpdate();
				
				//결과값은 영향을 받은 레코드의 수
				
					System.out.println(count+"count결과 출력");
					
				if(count==1){
					
					result = true;
					DBTemplate.commit(con);
					System.out.println("대여 가 가능하게 업데이트  완료되었다 시발!!!");
				
				}else{
					result = false;
					DBTemplate.rollback(con);
				}
				
			}//대여한 도서 있는지 여부 확인 if문 end///////
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	//도서반납 
	public boolean returnbookupdate(String keyword,String email){
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		boolean result = false;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		
		System.out.println("리턴 업데이트로 들어오긴했니???????????????????????????????????");
		try {
			
			String sql1 = "select * from rentreturn where remail=? and bisbn=?";
			
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, email);
			pstmt1.setString(2, keyword);
			
			rs = pstmt1.executeQuery();
			
			//대여한 도서가 있는 경우 status를 0으로 바꿔서 업데이트!!
			if(rs.next()){
				String sql = "update rentreturn set rstatus = 0, remail=null where bisbn =?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
				System.out.println(email+" : "+ keyword + " 여기는 업데이트 부분=============");
				
				int count = pstmt.executeUpdate();
				
				//결과값은 영향을 받은 레코드의 수
				
					System.out.println(count+"count결과 출력");
					
				if(count==1){
					
					result = true;
					DBTemplate.commit(con);
					System.out.println("대여 가 가능하게 업데이트  완료되었다 시발!!!");
				
				}else{
					result = false;
					DBTemplate.rollback(con);
				}
			}
			
			//대여한 도서가 없는 경우
			else{
				
				System.out.println("대여한 도서가 없습니다. 돌아가세용");
				result = false;
			}//대여한 도서 있는지 여부 확인 if문 end///////
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally{
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		}
		
		return result;
		
	}	
	
	
	
	
	
	
}
