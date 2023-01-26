package com.yedamHW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.EmpVO;

public class BookDAO {
	// 필드
	Connection conn;
	Statement stmt = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	String sql;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "book";
	String pass = "book";

	// 메소드

	// db연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("에러발생.");
			e.printStackTrace();
		}
	}

	// 관리자 메뉴 - 1. 책 등록(입력) (psmt)
	public int addBook(BookVO book) {
		return 0;

	}

	// 관리자 메뉴 - 2.대여목록 조회
	public List<BookVO> bookVoList() {
		sql = "select * from book order by ISBN";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setISBN(rs.getInt("ISBN"));
				book.setBookName(rs.getString("book_name"));
				book.setBookCount(rs.getString("book_count"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	// 관리자 메뉴 - 3. 조건별 조회 - 대여날짜 (stmt)
	public List<BookVO> getDateBook(String rentalDate1, String rentalDate2) {
		sql = "select * from book where rental_date " + "between to_date('" + rentalDate1 + "','yyyy-mm-dd') "
				+ "and to_date('" + rentalDate2 + "','yyyy-mm-dd') order by rental_date";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setISBN(rs.getInt("ISBN"));
				book.setBookName(rs.getString("book_name"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 관리자 메뉴 - 3. 조건별 조회 - 대여자 이름 (stmt)
	public BookVO getUserNameBook(String name) {
		return null;
	}

	// 관리자 메뉴 - 3. 조건별 조회 - 도서명 (stmt)
	public BookVO getBookName(String bookName) {
		return null;
	}

	// 관리자 메뉴 - 4. 반납 (수정)
	public int updateBook(int no, String returnDate) {
		return no;
	}

	// 관리자 메뉴 - 5. 삭제 (삭제)
	public int deleteBook(String rentalDate) {
		return 0;

	}
}
