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
		connect();
		sql = "INSERT INTO book( no, book_name)" 
				+ " VALUES((SELECT NVL(MAX(no), 100) + 1 "
				+ "FROM book), ?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, book.getBookName());

			r = psmt.executeUpdate(); // 처리된 건수

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	// 관리자 메뉴 - 2.대여목록 조회
	public List<BookVO> bookVoList() {
		sql = "select * from book order by no";
		
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setBookName(rs.getString("book_name"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				book.setBDeadline(rs.getString("deadline"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	// 관리자 메뉴 - 3. 조건별 조회 - 모든 미반납자 조회
	public List<BookVO> getNoReturn() {
		sql = "SELECT *" + " FROM book " + " WHERE return_date is null order by no";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setBookName(rs.getString("book_name"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 관리자 메뉴 - 3. 조건별 조회 - 날짜지정 (반납확인)
	public List<BookVO> getSelectDate(String rentalDate) {
		sql = "SELECT *" + " FROM book " + " WHERE return_date is null" + " and rental_date = TO_DATE('" + rentalDate
				+ "', 'YYYY-MM-DD') order by no";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setBookName(rs.getString("book_name"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 관리자 메뉴 - 3. 조건별 조회 - 기간별 조회 (반납확인)
	public List<BookVO> getDateBook(String rentalDate1, String rentalDate2) {
		sql = "SELECT *" + " FROM book " + " WHERE return_date is null " + " and rental_date" + "     BETWEEN TO_DATE('"
				+ rentalDate1 + "', 'YYYY-MM-DD') " + "     AND TO_DATE('" + rentalDate2 + "', 'YYYY-MM-DD') order by no";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setBookName(rs.getString("book_name"));
				book.setRentalDate(rs.getString("rental_date"));
				book.setReturnDate(rs.getString("return_date"));
				book.setUserName(rs.getString("u_name"));
				book.setUserPhone(rs.getString("u_phone"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 관리자 메뉴 - 4. 반납 (수정)
	public int updateBook(int no) {
		sql = "update book set return_date = sysdate where no = ?";
		connect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			r = psmt.executeUpdate(); // 처리된 건수

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	// 관리자 메뉴 - 5. 삭제 (반납확인시)
	public int deleteBook(int no) {
		sql = "delete from book where return_date is not null and no = ? ";
		connect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			r = psmt.executeUpdate(); // 처리된 건수

		} catch (SQLException e) {

		}
		return r;
	}

	// 유저 메뉴 - 1. 책 대여
	public int rentBook(int no, String userName, String userPhone) {
		sql = "update book set u_name = ? , u_phone = ? , rental_date = sysdate"
				+ ", deadline = sysdate + 7 where no = ?";
		connect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);
			psmt.setString(2, userPhone);
			psmt.setInt(3, no);

			r = psmt.executeUpdate(); // 처리된 건수

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	//대여 가능 책 조회
	public List<BookVO> possibleRentBook() {
		sql = "SELECT *" + " FROM book " + " WHERE rental_date is null";
		connect();
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setBookName(rs.getString("book_name"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
