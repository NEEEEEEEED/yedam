package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {
	Scanner sc = new Scanner(System.in);

	int menu = 0;

	List<int[]> list = new ArrayList<>();

	public LottoApp() {
		run();
	}

	private void run() {

		while (menu != 99) {
			menuInfo();
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 로또 생성
				makeLotto();
				break;

			case 2:
				// 로또 조회(내가 투입한 금액과 출력 번호)
				showInfo();
				break;

			case 99:
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

	private void showInfo() {
		System.out.println(("구매 한 금액>" + (list.size() * 1000) + "원"));

		for (int i = 0; i < list.size(); i++) {
			System.out.print((i % 5 + 1) + "번> ");
			for (int j = 0; j < 6; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();
			if ((i + 1) != 0 && (i + 1) % 5 == 0) {
				System.out.println("-----------------------------------------------");
			}
		}

	}

	private void makeLotto() {
		System.out.println("금액투입");
		int money;
		money = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < (money / 1000); i++) {
			list.add(makeNumber());
		}
		System.out.println("번호출력완료");

	}

	private int[] makeNumber() {
		int[] lottoNo = new int[6];
		for (int i = 0; i < 6; i++) {
			// 랜덤 데이터 뽑기
			lottoNo[i] = (int) (Math.random() * 45) + 1;

			// 인덱스가 0일때 중복 체크할 필요가 없다.
			if (i > 0) {
				// 인덱스가 1이상일 때 중복체크
				for (int j = 0; j < i; j++) {
					// 방금생성한 랜덤값과 내가 가지고 있는 값과 같으면
					if (lottoNo[j] == lottoNo[i]) {
						// 다시 i값 되돌리기
						i--;
						break;
					}
				}
			}
		}
		return lottoNo;
	}

	private void menuInfo() {
		System.out.println("메뉴선택");
		System.out.println("1.생성 2.조회 99.종료");

	}

}
