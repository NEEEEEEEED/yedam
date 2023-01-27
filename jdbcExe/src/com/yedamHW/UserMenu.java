package com.yedamHW;

import java.util.List;
import java.util.Scanner;

public class UserMenu {
	Scanner sc = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	
	public void exe() {
		
		while (true) {
			UserMenu();
			int UserMenu = sc.nextInt();

			if (UserMenu == 1) {
				rentBook();
			} else if (UserMenu == 2) {
				searchBook();
			} else if (UserMenu == 0) {
				System.out.println("이전 메뉴로 이동");
				break;
			}
		}
		
	}
	private void searchBook() {
		
		List<BookVO> list = dao.possibleRentBook();
		for (BookVO book : list) {
			System.out.println(book.bookList());
		}		
	}
	private void rentBook() {
		// 책 대여
		System.out.print("[책 대출] 도서번호 입력> ");
		int no = sc.nextInt();
		sc.nextLine();
		
		System.out.print("[책 대출] 대여자 이름 입력> ");
		String userName = sc.next();
		
		System.out.print("[책 대출] 대여자 전화번호 입력 (EX)010-0000-0000)> ");
		String userPhone = sc.next();
		

		if (dao.rentBook(no, userName, userPhone) > 0) {
			System.out.println("[책 대출] 대출 처리 성공");
		} else {
			System.out.println("[책 대출] 처리중 에러");
		}
		
	}
	private void UserMenu() {
		System.out.println
		 ("========================================================================");
		System.out.println
		 ("                 1.책 대출     2.대여가능한 책 조회      0.이전 메뉴             ");
		System.out.println
		 ("========================================================================");
		System.out.print
		 ("메뉴 입력>> ");
	}
}
