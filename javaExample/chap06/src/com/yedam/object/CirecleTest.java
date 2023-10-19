package com.yedam.object;

public class CirecleTest {

	public static void main(String[] args) {
		// 반지름이 5인 원의 면적 계산
		// circle 객체 생성
////		Circle cir = new CircleSingle(5);
//		// 반지름 5 초기화\
////		cir.r = 5;
//		// area
//		double result = cir.area();
//		// 결과 출력
//		System.out.println(result);
//
//		
//		Circle cir2 = new Circle();
//		cir2.r = 10;
//		//static = 정적 = 공유
//		// 클래스 파일 로딩
//		//객체 생성 없이 클래스 이름으로 접근 가능
//		System.out.println(Circle.pi);
//		
		//싱글톤 
		CircleSingle cirSingle = CircleSingle.getInstance();
		cirSingle.r = 10;
		double cs = cirSingle.area();
		System.out.println(cs);
	}

}
