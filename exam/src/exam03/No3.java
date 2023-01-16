package exam03;

public class No3 {

	public static void main(String[] args) {
		// 큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = new int[4];
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			if (money >= 500) {
				coinUnit[i] = 500;
				int coin500 = money / coinUnit[i];
				System.out.print("500원 : " + coin500 + "개");
				money = money - (coin500 * 500);
			} else if (money >= 100) {
				coinUnit[i] = 100;
				int coin100 = money / coinUnit[i];
				System.out.print(", 100원 : " + coin100 + "개");
				money = money - (coin100 * 100);
			} else if (money >= 50) {
				coinUnit[i] = 50;
				int coin50 = money / coinUnit[i];
				System.out.print(", 50원 : " + coin50 + "개");
				money = money - (coin50 * 50);
			} else if (money >= 10) {
				coinUnit[i] = 10;
				int coin10 = money / coinUnit[i];
				System.out.print(", 10원 : " + coin10 + "개");
				money = money - (coin10 * 10);
			}

		}
		// 출력 예시) 500원 : 5개, 100원 : 1개, 50원 : 1개, 10원 : 3개

	}

}
