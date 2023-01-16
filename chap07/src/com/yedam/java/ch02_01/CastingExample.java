package com.yedam.java.ch02_01;

public class CastingExample {

	public static void main(String[] args) {
		Parent parent = new Child(); // 오류가 안나는 것은 상속된 상태 + 자동변환 됨
		parent.method1();
		parent.method2();
//		parent.method3();  변수 타입이 Parent 임으로 Child 타입에 있는 method3 사용 불가

		System.out.println();

		Child child = (Child) parent;
		child.method1();
		child.method2();
		child.method3();

		System.out.println();

		Parent pa = new Parent();
		if (pa instanceof Child) {
			Child ch = (Child) pa;
			ch.method1();
			ch.method2();
			ch.method3();
		} else {
			System.out.println("변수 pa의 인스턴스는 Child 클래스의 인스턴스가 아닙니다.");
		}

	}

}
