package com.yedam.java.ch03;

public class Course {
	public static void registerCourse1(Applicant<?> applicant) {
		String message = applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함";
		System.out.println(message);
	}

	// Person , worker만 등록가능
	public static void registerCourse2(Applicant<? super Worker> applicant) {
		String message = applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함";
		System.out.println(message);
	}

	// Student, HighStudent, MiddleStudent
	public static void registerCourse3(Applicant<? extends Student> applicant) {
		String message = applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함";
		System.out.println(message);
	}
}
