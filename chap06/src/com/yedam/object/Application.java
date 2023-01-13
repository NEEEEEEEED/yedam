package com.yedam.object;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// 클래스 생성해서 객체 만든 다음 객체 바로 사용.
		// 객체를 한 곳에 모아서 관리하는 형태
		// 배열
		// int[] ary = new int[4];
		// Student[] stdAry = new Student[10];
		// 학생 정보 보관하는 배열
		Student[] stdAry = null;
		int stdNum = 0;
		Scanner sc = new Scanner(System.in);

		// while문을 활용해서 학생 관리 프로그램 작성.
		while (true) {
			System.out.println("===============================================");
			System.out.println("| 1.학생 수 | 2.정보입력 | 3.정보확인 | 4.분석 | 5.종료 |");
			System.out.println("===============================================");

			int selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				// Student 클래스로 만들어지는 객체를 몇개나 배열에 너흘지
				// 에 대한 값을 받아옴
				System.out.println("학생수>");
				stdNum = Integer.parseInt(sc.nextLine());

			} else if (selectNo == 2) {
				stdAry = new Student[stdNum];
				for (int i = 0; i < stdAry.length; i++) {
					// 객체 배열에 있는 각 인덱스에 존재는 student객체에게
					// 데이터를 제공하기 위해서 임시 객체를 만듬.
					// 1번 방식
//					Student std = new Student();
//					std.name = "이름";
//					std.age = 10;
//					stdAry[i] = std;

					// 2번 방식
					stdAry[i] = new Student();
					System.out.println("이름>");
					stdAry[i].name = sc.nextLine();
					System.out.println("나이>");
					stdAry[i].age = Integer.parseInt(sc.nextLine());
//					System.out.println("학교>");
//					stdAry[i].schoolName = sc.nextLine();

					// 성적 입력
					System.out.println("국어>");
					stdAry[i].kor = Integer.parseInt(sc.nextLine());
					System.out.println("영어>");
					stdAry[i].eng = Integer.parseInt(sc.nextLine());
					System.out.println("수학>");
					stdAry[i].math = Integer.parseInt(sc.nextLine());
				}
			} else if (selectNo == 3) {
				for (Student std : stdAry) {
					std.getInfo();
				}

			} else if (selectNo == 4) {
				// 총합, 평균
				int total = 0;
				double avg = 0;
				System.out.println("전체 학생 총합/평균 조회");
				for (int i = 0; i < stdAry.length; i++) {
					total = stdAry[i].kor + stdAry[i].eng + stdAry[i].math;
					avg = total / 3.0;
					System.out.println(stdAry[i].name + " 학생>");
					System.out.println("총합 : " + total + " 평균 : " + avg);
				}
				// 최댓값, 최솟값 구하기
				int max = 0;
				int min = 0;
				for (int i = 0; i < stdAry.length; i++) {

					max = stdAry[i].kor;
					min = stdAry[i].kor;
					if (stdAry[i].eng < stdAry[i].math) {
						if (max < stdAry[i].math) {
							max = stdAry[i].math;
						} else {
							if (max < stdAry[i].eng) {
								max = stdAry[i].eng;
							}
						}
						System.out.println(stdAry[i].name + "최고 성적 : " + max);
					}
					if (stdAry[i].eng > stdAry[i].math) {
						if (min > stdAry[i].math) {
							min = stdAry[i].math;
						} else {
							if (min > stdAry[i].eng) {
								min = stdAry[i].eng;
							}
						}
						System.out.println(stdAry[i].name + "최저 성적 : " + min);
					}

				}

			} else if (selectNo == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}

}
