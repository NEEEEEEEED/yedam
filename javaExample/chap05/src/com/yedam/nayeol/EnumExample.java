package com.yedam.nayeol;

import java.util.Calendar;

public class EnumExample {

	public static void main(String[] args) {
		// Week타입의 today변수
		// today는 Week가 가지고 있는 데이터만 가질 수 있다.
		// today 데이터 범위는 Monday~Sunday 총 7개만 가능.
		Week today = null;

		// 오늘의 요일 확인
		Calendar cal = Calendar.getInstance();

		// JAVA에서는 일요일 = 1, 월요일 = 2,...,토요일 =7
		// 오늘 요일을 숫자로 알려줌
		int week = cal.get(Calendar.DAY_OF_WEEK);

		//알려준 숫자를 case로 이용 -> enum에 저장한 Week의 값을 today 넣음
		switch (week) {
		case 1:
			today = Week.Sunday;
			break;
		case 2:
			today = Week.Monday;
			break;
		case 3:
			today = Week.Tuesday;
			break;
		case 4:
			today = Week.Wednesday;
			break;
		case 5:
			today = Week.Thursday;
			break;
		case 6:
			today = Week.Friday;
			break;
		case 7:
			today = Week.Saturday;
			break;
		}

		System.out.println("오눌 요일 : " + today);
	}

}
