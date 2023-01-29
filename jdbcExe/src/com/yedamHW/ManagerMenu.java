package com.yedamHW;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.yedam.EmpDAO;
import com.yedam.EmpVO;

public class ManagerMenu {
	Scanner sc = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	LoginDAO Ldao = new LoginDAO();

	public void exe() {
		
		while(true) {
			loginMenu();
			int Login = sc.nextInt();

			if (Login == 1) {
				if(loginPage() == 1) {
					loginSuccess();
					break;
				} else {
					logInFaile();
					
					
				}

			} else if (Login == 0) {
				System.out.println("이전 메뉴로 이동");
				return;
			}
			
		}
		
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

	private void logInFaile() {
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		System.out.println(""
				+ "           ███████  █████  ██ ██      ██    ██ ██████  ███████ \r\n"
				+ "           ██      ██   ██ ██ ██      ██    ██ ██   ██ ██      \r\n"
				+ "           █████   ███████ ██ ██      ██    ██ ██████  █████   \r\n"
				+ "           ██      ██   ██ ██ ██      ██    ██ ██   ██ ██      \r\n"
				+ "           ██      ██   ██ ██ ███████  ██████  ██   ██ ███████ \r\n");
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		
	}

	private void loginSuccess() {
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		System.out.println(""
				+ "        ███████ ██    ██  ██████  ██████ ███████ ███████ ███████ \r\n"
				+ "        ██      ██    ██ ██      ██      ██      ██      ██      \r\n"
				+ "        ███████ ██    ██ ██      ██      █████   ███████ ███████ \r\n"
				+ "             ██ ██    ██ ██      ██      ██           ██      ██ \r\n"
				+ "        ███████  ██████   ██████  ██████ ███████ ███████ ███████ \r\n"
				+ "");
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		
	}

	private int loginPage() {
		int check = 0;
		System.out.println();
		System.out.print("아이디 입력>> ");
		String managerId = sc.next();
		System.out.println();
		System.out.print("비밀번호 입력>> ");
		String managerPw = sc.next();

		
		List<LoginVO> list = Ldao.LoginCheck();
		for (int i = 0 ; i < list.size(); i++) {
			if(managerId.equals(list.get(i).getManagerId()) && managerPw.equals(list.get(i).getManagerPw())) {
				check = 1;
				break;
			} else {
				check = 0;
			}
		}
		return check;
		
		
	}

	private void loginMenu() {
		System.out.println
		 ("========================================================================");
		System.out.println
		 ("                        1. 로그인         0.이전 메뉴 ");
		System.out.println
		 ("========================================================================");
		System.out.print
		 ("메뉴 입력>> ");
		
	}

	private void managerMenu() {
		System.out.println
		 ("========================================================================");
		System.out.println(" 1.도서 등록  2.전체 대여목록 조회  3.미"
				+ "반납자 조회  4.도서반납  5.대여목록삭제  0.로그아웃");
		System.out.println
		 ("========================================================================");
		System.out.print
		 ("메뉴 입력>> ");
	}

	public void enrollBook() {
		// 책등록
		System.out.println("[도서 등록] 도서 제목 입력>> ");
		String bookName = sc.next();

		BookVO vo = new BookVO();

		vo.setBookName(bookName);

		if (dao.addBook(vo) > 0) {
			System.out.println("[도서 등록] 등록 성공");
		} else {
			System.out.println("처리중 에러");
		}
	}

	public void rentalList() {
		// 대여 조회
		List<BookVO> list = dao.bookVoList();
		for (BookVO book : list) {
			System.out.println(book.toString());
		}

	}

	public void rentalcondition() {
		// 조건별 조회

		while (true) {
			System.out.println("1. 기간별 조회 | 2. 날짜 지정 조회 | 3. 전체 미반납자 | 0. 이전메뉴");
			System.out.print("메뉴 입력>> ");
			int selectConditionMenu = sc.nextInt();

			if (selectConditionMenu == 1) {
				periodSelect();
			} else if (selectConditionMenu == 2) {
				dateSelect();
			} else if (selectConditionMenu == 3) {
				noReturn();
			} else if (selectConditionMenu == 0) {
				System.out.println("메인메뉴로 이동");
				break;
			}
		}

	}

	// 미반납자 조회
	private void noReturn() {

		List<BookVO> list = dao.getNoReturn();
		for (BookVO book : list) {
			System.out.println(book.toString());
		}

	}

	// 미반납자 날짜지정 조회
	private void dateSelect() {
		System.out.println("날짜 지정> ");
		String rentalDate = sc.next();
		
		List<BookVO> list = dao.getSelectDate(rentalDate);
		if(list.isEmpty()) {
			System.out.println("해당 날짜에 대출한 도서가 없습니다.");
		} else {
			for (BookVO book : list) {
				System.out.println(book.toString());
			}
		}
		
	}
	// 미반납자 기간 조회
	private void periodSelect() {
		System.out.println("시작날짜> ");
		String rentalDate1 = sc.next();

		System.out.println("마지막날짜> ");
		String rentalDate2 = sc.next();

		List<BookVO> list = dao.getDateBook(rentalDate1, rentalDate2);
		for (BookVO book : list) {
			System.out.println(book.toString());
		}

	}
	// 반납처리
	public void returnBook() {
		System.out.println("대출번호 입력> ");
		int no = sc.nextInt();
		sc.nextLine();


		if (dao.updateBook(no) > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("처리중 에러");
		}
	}

	// 삭제
	public void deleteList() {
		System.out.println("삭제할 날짜 입력> ");
		String deadline = sc.next();

		if (dao.deleteBook(deadline) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제할 데이터가 없습니다.");
		}

	}
}
