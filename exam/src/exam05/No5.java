package exam05;

import java.util.Scanner;

public class No5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] diceAry = null;
		int diceRan = 0;
		int diceNum = 0 ;
		int count = 0;
		while (true) {
			System.out.println("===1.주사위 크기|2.주사위 굴리기|3.결과 보기|4.가장 많이 나온 수|5.종료===");
			System.out.println("메뉴 >");

			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				System.out.println("주사위 크기 >");
				diceNum = Integer.parseInt(sc.nextLine());
				if(diceNum < 5) {
					System.out.println("5~10 입력하세요");
				} else if (diceNum >10) {
					System.out.println("5~10 입력하세요");
				}
				
			} else if (menu == 2) {
				diceAry = new int[diceNum];
				while(true) {
					diceRan = (int)(Math.random()*diceNum)+1;
					count++;
					diceAry[diceRan-1]++;
					if(diceRan == 5) {
						break;
					} 
							
				}

			} else if (menu == 3) {
				for(int i = 0;i<diceAry.length;i++) {
					System.out.println(i+"은"+diceAry[i]+"번 나왔습니다.");
				}
			} else if (menu == 4) {
				int max = diceAry[0];
				for(int i = 0;i<diceAry.length;i++) {
					
				}
			} else if (menu == 5) {
				System.out.println("end of prog");
				break;
			}

		}

	}

}
