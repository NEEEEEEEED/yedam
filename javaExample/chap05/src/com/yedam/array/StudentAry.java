package com.yedam.array;

import java.util.Scanner;

public class StudentAry {

	public static void main(String[] args) {
		// 한 학생의 성적을 입력.
		// 과목 수
		int subjectNum = 0;
		int[] score = null;
		Scanner sc = new Scanner(System.in);

		
		
		while (true) {
			System.out.println("====================================");
			System.out.println("1.과목수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("====================================");
			System.out.println("메뉴 입력>");

			int selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				System.out.println("입력>");
				int no;
				no = Integer.parseInt(sc.nextLine());
				score = new int[no];
				System.out.println("입력된 과목수 : " + score.length);


			} else if (selectNo == 2) {
				for (int i = 0; i < score.length; i++) {
					System.out.println("입력>");
					score[i] = Integer.parseInt(sc.nextLine());

				}
			} else if (selectNo == 3) {
				for (int i = 0; i < score.length; i++) {
					System.out.println(score[i]);
				}
			} else if (selectNo == 4) {
				//총합
				int sum =0;
				for (int i = 0; i < score.length; i++) {
					sum += score[i];
				}
				System.out.println("총합 : " + sum);
				//평균
				double avg = (double)sum/score.length;
				System.out.println("평균 : " + avg);
				
			} else if (selectNo == 5) {
				System.out.println("end of prog");
				break;
			}

		}

	}

}
