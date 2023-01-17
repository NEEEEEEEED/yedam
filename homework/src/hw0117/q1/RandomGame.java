package hw0117.q1;

import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Keypad game;
		int randomGame = (int) (Math.random() * 2) + 1;
		System.out.println(randomGame);
		boolean run = true;

		while (run) {
			if (randomGame == 1) {
				game = new RPGgame();
				boolean game1 = true;
				while (game1) {
					System.out.println(
							"================================================================================");
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.println(
							"================================================================================");
					System.out.print("choice>>");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
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
						randomGame = 2;
						game1 = false;
						break;
					case 9:
						run = false;
						game1 = false;
						break;
					}
				}

			} else if (randomGame == 2) {
				game = new ArcadeGame();
				boolean game2 = true;
				while (game2) {
					System.out.println(
							"================================================================================");
					System.out.println(
							"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
					System.out.println(
							"================================================================================");
					System.out.print("choice>>");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
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
						randomGame = 1;
						game2 = false;
						break;
					case 9:
						run = false;
						game2 = false;
						break;
					}
				}
			}

		}
	}

}
