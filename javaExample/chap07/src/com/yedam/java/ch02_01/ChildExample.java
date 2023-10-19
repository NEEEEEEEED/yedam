package com.yedam.java.ch02_01;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();

		System.out.println();
		
		
		Parent parent = child;	//자동 타입 변환 child => parent
		parent.method1();
		parent.method2();
//		parent.method3();	//method3는 Child 클래스에 있음으로 parent 인스턴스는 method3를 못찾음
		
	}

}
