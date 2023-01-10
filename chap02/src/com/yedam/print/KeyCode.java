package com.yedam.print;

import java.io.IOException;
import java.util.Scanner;

public class KeyCode {

	public static void main(String[] args) throws IOException {
		//keyCode 하나의 문자를 받아올때
		int keyCode = 0;
		
		System.out.println("입력>");
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력>");
		//scanner.nextLine(); => enter키 이전까지 데이터를 받아오세요.
		//scanner 다양한 종류가 있지만 섞어쓰면 오류 많이 발생, nextLine으로 통일해서 사용
		String inputDate = scanner.nextLine();
		System.out.println("Scanner 활용 : " + inputDate);
		
		//기본 타입, == ( 1==1, 1.2==1.3 )
		//문자열 내용 비교 ( == 사용불가)
		if (inputDate.equals("yedam")) {
			System.out.println("yedam과 일치합니다.");
		}
		
	}

}
