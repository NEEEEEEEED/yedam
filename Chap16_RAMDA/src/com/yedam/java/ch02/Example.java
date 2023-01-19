package com.yedam.java.ch02;

public class Example {
	public static void main(String[] args) {
		// 매개변수가 없는 경우
		Workable work = () -> {
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		};
		work.work();

		work = () -> System.out.println("나도 퇴근할래");
		work.work();

		// 매개변수가 있는 경우 (1개냐 2개냐 차이 있음)
		Speakable spk = (x) -> {
			System.out.println("I can speak");
			System.out.println("no you can't");
		};
		spk = x -> System.out.println("go home....");
		spk.Speak("");

		// 리턴값이 있는 경우 (한줄이 리턴이면 리턴도 생략)
		Calculator calc = (x, y) -> (int)(x + y);

		System.out.println(calc.plus(5.6, 6.5));
	}
}
