package com.yedam.review;

import java.util.Scanner;

public class StringAPI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 문자열 뒤집기
		System.out.println("뒤집을 문자열 입력>");
		String str = sc.nextLine();
		
		//String.length -> 문자열 길이
		//String.charAt(위치); -> 위치에 따른 문자 출력
		for(int i = str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		//2. 입력한 문자열 개수 세기
		//중복되는 문자가 몇개가 존재하는지,
		//a~z : 26개가 다 들어온다는 가정.
		//0~25, 각각의 인덱스 어떤 문자를 의미.
		//0 -> a, 1 -> b.... 25->z
		//아스키코드 : a => 97, b => 98...
		// 내가 입력한 문자 - 97 = 배열의 인덱스 값
		// "aabbccdd" -> 첫번째 a(내가 입력한 문자)
		// ary[내가 입력한 문자 - 97] => 0~25(a~z)의 자리와 갯수를 의미.
		
		int charAry[] = new int[26];
		System.out.println("문자열 입력>");
		//입력한 문자열 소문자 변환
		String str2 = sc.nextLine().toLowerCase();
		
		for(int i = 0; i<str2.length();i++) {
			char ch = str2.charAt(i); //다른 방식(subString)
			//str2.substring(i, i+1);
			//입력한 문자 : "aabbccdd";
			//첫번째 문자 a를 꺼내왔다.
			charAry[ch - 'a']++;
		}
		
		for(int i = 0; i < charAry.length; i++) {
			if(charAry[i] != 0) {
				System.out.println((char)(97+i) + " " + charAry[i]+"개");
			}
		}

		//3. 만 나이 계산기( 올해 기준 +- 100살 )
		
		//1. 계산식(하드 코딩) -> 올해만 사용
		//1-1) 2000년 이후 2023년 이전 출생 -> (23-태어난 년도)+1
		//1-2) 1922년 이후 2000년 이전 출생 -> (123-태어난 년도)
		
		System.out.println("생년월일>");
		String birth = sc.nextLine();
		
		int birthNo = Integer.parseInt(birth.substring(0, 2));
		
		if(birthNo <= 23) { // 2000년 이후 2023년 이전 출생 -> (23-태어난 년도)+1
			System.out.println("나이 : " + (23-birthNo)+1);
		//1922~1999
		} else if(birthNo > 23) { //1922년 이후 2000년 이전 출생 -> (123-태어난 년도)
			System.out.println("나이 : " + (123-birthNo));
		}
		
		
		//1. 계산식(일반화)
		//Calendar, date(simpledateFormat) => 오늘 날짜, 년도
		//1-1) 2000년 이후 2023년 이전 출생 -> (기준 년도-태어난 년도)+1
		//1-2) 1922년 이후 2000년 이전 출생 -> (기준 년도-태어난 년도)
		
		//Stringbuilder
		//String 단점 보완
		
		//메모리 5개 사용
		String a = "a";
		a += "a";
		a += "a";
		a += "a";
		a += "a";
		
		//메모리 1개 사용
		StringBuilder sb = new StringBuilder();
		sb.append("aaa"); //"aaa"
		sb.append(11);
		sb.append(false);
		
		System.out.println(sb);
	}
}
