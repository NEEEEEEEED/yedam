package com.yedamHW;

import java.util.List;
import java.util.Scanner;

import com.yedam.EmpDAO;
import com.yedam.EmpVO;

public class bookMain {
	Scanner sc = new Scanner(System.in);
	BookDAO dao = new BookDAO();

	public void exe() {

		while (true) {
			managerMenu();
			int managerMenu = sc.nextInt();

			if (managerMenu == 1) {
				enrollBook();
			} else if (managerMenu == 2) { 
				rentalList();
			} else if (managerMenu == 3) {
				rentalcondition();
			} else if (managerMenu == 4) {
				returnBook();
			} else if (managerMenu == 5) {
				deleteList();
			} else if (managerMenu == 0) {
				System.out.println("로그아웃 합니다.");
				break;
			}
		}
		System.out.println("end of program.");


	}

	private void managerMenu() {
		System.out.println("1. 책 등록 | 2. 대여목록 조회 | 3. 조건별 조회 | 4. 반납 | 5. 삭제 | 0.로그아웃");
	}

	public void enrollBook() {
		// 책등록
	}

	public void rentalList() {
		// 대여목록 조회
	}

	public void rentalcondition() {
		// 조건별 조회
	}
	public void returnBook() {
		// 반납
	}
	public void deleteList() {
		System.out.println("삭제할 날짜 입력> ");
		String rentalDate = sc.nextLine();

		if (dao.deleteBook(rentalDate) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("처리중 에러");
		}

	}
}
