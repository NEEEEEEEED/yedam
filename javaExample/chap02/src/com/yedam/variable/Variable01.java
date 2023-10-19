package com.yedam.variable;

public class Variable01 {

	public static void main(String[] args) {
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println( "총 " + totalMinute + "분");
		
		int value = 1;
		int result = value + 10;
		System.out.println(result);
		
		int x = 3;
		int y = 5;
		//x -> y, y -> x 변경
		int z = 0;
		//x의 데이터를 미리 z에 담아두고
		z = x;	//z=3
		x = y;	//x=5
		y = z;	//y=3
		System.out.println(x);
		System.out.println(y);
		

	}

}
