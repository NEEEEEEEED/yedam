package com.yedam.object;

public class ExeApp {

	public static void main(String[] args) {
		// Book 클래스
		// 책의 종류, 가격, 출판사, 도서번호
		// 정보는 원하는 방식 아무거나 활용해서 정보 입력.
		// getInfo 메소드 객체가 가진 정보 출력
		// getInfo의 출력 예시
		// 혼자 공부하는 자바
		// # 내용
		// 1) 종류 : 학습서
		// 2) 가격 : 24000원
		// 3) 출판사 : 한빛미디어
		// 4) 도서번호 : yedam-001
		// 다른 예시
		// 이것이 리눅스다
		// 1) 종류 : 학습서
		// 2) 가격 : 32000원
		// 3) 출판사 : 한빛미디어
		// 4) 도서번호 : yedam-002

//		Book b1 = new Book("혼자 공부하는 자바", 24000, "001");
//		Book b2 = new Book("이것이 리눅스다", 32000, "002");
//		b1.getInfo();
//		b2.getInfo();
//		
//		Book b3 = new Book();

//		Car car1 = new Car();
//		System.out.println("car1.company : " + car1.company);
//		System.out.println();
//		
//		Car car2 = new Car("자가용");
//		System.out.println("car2.company : " + car2.company);
//		System.out.println("car2.model : " + car2.model);
//		System.out.println();

//		Calculator calc = new Calculator();
//		double result = calc.sub(1, 1);
//		System.out.println(result);
//
//		calc.powerOn();
//		calc.powerOff();
//
//		int sumResult = calc.sum2(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		System.out.println("총합 : " + sumResult);
//		sumResult = calc.sum2(1, 2, 3, 4, 5);
//		System.out.println("총합 : " + sumResult);

		Score sc = new Score(50,40,70);
		
		sc.getInfo();
	}

}
