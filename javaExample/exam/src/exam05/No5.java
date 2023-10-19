package exam05;

import java.util.Scanner;

public class No5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dice = 0;
		int diceRan = 0;
		int cnt = 0;
		int[] diceAry = null;
		while(true) {
			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
			System.out.println("메뉴 >");
			int selectNum = Integer.parseInt(sc.nextLine());
			if(selectNum == 1) {
				System.out.println("주사위 크기 >");
				dice = Integer.parseInt(sc.nextLine());
				if(dice > 10) {
					System.out.println("5 ~ 10 입력해주세요");
				}else if (dice < 5) {
					System.out.println("5 ~ 10 입력해주세요");
				}
			}else if(selectNum == 2) {
				diceAry = new int[dice];
				while(true) {
					diceRan = (int) (Math.random()*dice)+1;
					cnt++;
					diceAry[diceRan-1]++;
					if(diceRan == 5) {
						break;
					}
				}
				System.out.println("5가 나올 때까지 주사위를 " + cnt + "번 굴렸습니다.");
			}else if(selectNum == 3) {
				for(int i = 0; i < diceAry.length; i++) {
					System.out.println(i+1 + "은 " + diceAry[i]+"번 나왔습니다.");
				}
			}else if(selectNum == 4) {
				int diceMax = diceAry[0];
				int Index = 0;
				for(int i = 0; i < diceAry.length; i++) {
					if(diceMax < diceAry[i]) {
						diceMax = diceAry[i];
						Index = i;
					}
				}
				System.out.println("가장 많이 나온 수는 " + (Index+1) + "입니다.");
			}else if(selectNum == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}
