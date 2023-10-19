package com.yedam.object;

public class Book {
	// 필드
	String name;
	String kind = "학습서";
	int price;
	String publish = "한빛미디어";
	String ISBN;

	// 생성자
	Book(String name, int price, String ISBN) {
		// this 는 테이블의 주인을 지칭
		this.name = name;
		this.price = price;
		this.ISBN = ISBN;
	}
	
	// 매개 변수  순서에 따른 생성자 오버로딩 -> 다양한 생성자를 이용할 수 있음
	// 데이터 타입 기준으로 순서를 따진다.
	Book(int price, String name, String ISBN) {
		this.name = name;
		this.price = price;
		this.ISBN = ISBN;
	}
	
	// 매개 변수 갯수
	Book(int price, String name) {
		this.name = name;
		this.price = price;
		this.ISBN = ISBN;
	}
	
	//기본 생성자
	Book(){
		
	}
	// 메소드
	void getInfo() {
		System.out.println(name);
		System.out.println("1) 종류 : " + kind);
		System.out.println("2) 가격 : " + price + "원");
		System.out.println("3) 출판사 : " + publish);
		System.out.println("4) 도서번호 : " + "yedam-" + ISBN);
	}
	
	
	
	
	
	
}
