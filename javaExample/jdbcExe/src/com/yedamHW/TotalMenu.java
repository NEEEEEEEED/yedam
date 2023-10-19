package com.yedamHW;

import java.util.Scanner;

public class TotalMenu {
	ManagerMenu mm = new ManagerMenu();
	UserMenu um = new UserMenu();
	Scanner sc = new Scanner(System.in);

	public void exe() {

		while (true) {
			mainMenu();
			int managerMenu = sc.nextInt();

			if (managerMenu == 9) {
				mm.exe();
				
			} else if (managerMenu == 1) {
				um.exe();
				
			} else if (managerMenu == 0) {
				logOut();
				break;
			}
		}
		

	}
	
	private void logOut() {
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		System.out.println(""
				+ "           ██       ██████   ██████       ██████  ██    ██ ████████ \r\n"
				+ "           ██      ██    ██ ██           ██    ██ ██    ██    ██    \r\n"
				+ "           ██      ██    ██ ██   ███     ██    ██ ██    ██    ██    \r\n"
				+ "           ██      ██    ██ ██    ██     ██    ██ ██    ██    ██    \r\n"
				+ "           ███████  ██████   ██████       ██████   ██████     ██    \r\n");
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		
	}

	private void mainMenu() {
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		System.out.println(""
				+ " ██████ ██   ██ ███████  ██████ ██   ██        ██████  ██    ██ ████████ \r\n"
				+ "██      ██   ██ ██      ██      ██  ██        ██    ██ ██    ██    ██    \r\n"
				+ "██      ███████ █████   ██      █████   █████ ██    ██ ██    ██    ██    \r\n"
				+ "██      ██   ██ ██      ██      ██  ██        ██    ██ ██    ██    ██    \r\n"
				+ " ██████ ██   ██ ███████  ██████ ██   ██        ██████   ██████     ██    \r\n");
		System.out.println(
				  "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n"
				+ "████████████████████████████████████████████████████████████████████████ \r\n");
		System.out.println
				 ("========================================================================");
		System.out.println
				 ("                 1.도서대출        9.관리자 메뉴        0.종료                 ");
		System.out.println
			   	 ("========================================================================");
		System.out.print
				 ("메뉴 입력>> ");
	}

	
	
	
	

}
