package homework;

import java.util.Scanner;


public class Day04 {
	static Item[] itemAry = null;
	static int itemNum = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static int menuSelect() {
		System.out.println("=======================================================");
		System.out.println("| 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료 |");
		System.out.println("========================================================");

		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		// 출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.

		

		// while문을 활용해서 학생 관리 프로그램 작성.
		while (true) {
			//메소드 분리
			int menu = menuSelect();

			if (menu == 1) {
				System.out.println("상품수>");
				itemNum = Integer.parseInt(sc.nextLine());

			} else if (menu == 2) {
				itemAry = new Item[itemNum];
				for (int i = 0; i < itemAry.length; i++) {
					itemAry[i] = new Item();
					System.out.println("상품>");
					itemAry[i].item = sc.nextLine();
					System.out.println("가격>");
					itemAry[i].price = Integer.parseInt(sc.nextLine());
				}
			} else if (menu == 3) {
				for(Item a : itemAry) {
					a.getPrice();
				}
			} else if (menu == 4) {
				// 최고가 
				int total = 0;
				int max =itemAry[0].price;
				String maxitem = "";
				for(int i=0;i<itemAry.length;i++) {
					if(max < itemAry[i].price) {
						max = itemAry[i].price;
						maxitem = itemAry[i].item;
					}
					total += itemAry[i].price;
				}
				System.out.println("최고가 : " + maxitem);
				System.out.println("최고가 제품 : " + max);
				// 최고가 제외 가격의 총합
				System.out.println("최고가 제외 가격의 총합 : " + (total - max));
			} else if (menu == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}
	
	
	
}
