package com.yedamHW;

public class BookVO {
	private int no;
	private String bookName;
	private String Deadline;
	private String userName;
	private String userPhone;
	private String rentalDate;
	private String returnDate;
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDeadline() {
		return Deadline;
	}
	public void setBDeadline(String Deadline) {
		this.Deadline = Deadline;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		if(rentalDate != null) {
			rentalDate = rentalDate.substring(0, 10);
		} else {
			rentalDate = " - ";
		}
		if(returnDate != null) {
			returnDate = returnDate.substring(0, 10);
		} else {
			returnDate = " - ";
		}
		if(Deadline != null) {
			Deadline = Deadline.substring(0, 10);
		} else {
			Deadline = " - ";
		}
		if(userName != null) {
		} else {
			userName = " - ";
		}
		if(userPhone != null) {
		} else {
			userPhone = " - ";
		}
		return " 도서번호: " + no + "| 도서제목: " + bookName +  "| 대출자: " + userName
				+ "| 연락처: " + userPhone + "| 대출일: " + rentalDate + "| 반납일: " + returnDate + " 반납예정일: " + Deadline ;
	}
	public String bookList() {
		return " 도서번호 : " + no + "   | 책 제목 : " + bookName
			 + "\n-------------------------------------------";
	}
	
	
	
	
	
}
