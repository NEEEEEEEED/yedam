package testExample;

import java.util.Scanner;

public class RandomGameExample {
	public static Keypad getRandomGame() {
		Keypad game = null;
		int random = (int) (Math.random() * 2 + 1);
		switch(random) {
		case 1:
			game = new RPGgame();
			break;
		case 2:
			game = new ArcadeGame();
			break;
		}
		return game;
	}

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);

		Keypad game = getRandomGame();

		while (run) {
			System.out.println(
					"============================================================================================");
			System.out.println(
					"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println(
					"============================================================================================");
			System.out.print("choice>>");
			int menuNo = Integer.parseInt(sc.nextLine());

			switch (menuNo) {
			case 1:
				game.leftUpButton();
				break;
			case 2:
				game.leftDownButton();
				break;
			case 3:
				game.rightUpButton();
				break;
			case 4:
				game.rightDownButton();
				break;
			case 5:
				game.changeMode();
				break;
			case 0:
				game = getRandomGame();
				break;
			case 9:
				System.out.println("EXIT");
				run = false;
				break;
			default:
				System.out.println("메뉴를 잘못 선택하였습니다.");
			}
		}
	}
}
