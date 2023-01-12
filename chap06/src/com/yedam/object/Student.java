package com.yedam.object;

public class Student {

	// 필드, 객체의 속성(정보,데이터)가 저장되는 부분
	// 이름
	String name;
	// 나이
	int age;
	// 학교이름 = default 설정
	String schoolName ;
	int kor;
	int eng;
	int math;

	//
	// 생성자, 객체 초기화(생성)할 때
	// 어떠한 행동(생성자 안에 정의된)을 하고 객체를 생성하라
	// 클래스와 이름이 같아야함
//	Student() {
//
//	}

	// 기본 생성자 -> 생성하지 않아도 컴파일(실행) 자바에서 알아서 생성.

	// 생성자 -> 매개변수, 객체 생성시 실행문 정의.
	Student() {
		System.out.println("객체 생성 중");
	}

	// 메소드, 객체를 생성 후 기능을 사용할 때 정의하는 부분
	void getInfo() {
		System.out.println("학생의 이름 : " + name);
		System.out.println("학생의 나이 : " + age);
		System.out.println("학생의 학교 : " + schoolName);
		System.out.println("학생의 국어 점수 : " + kor);
		System.out.println("학생의 영어 점수 : " + eng);
		System.out.println("학생의 수학 점수 : " + math);
	}

}
