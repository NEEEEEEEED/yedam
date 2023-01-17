package hw0117.q1;

public class GameExample {

	public static void main(String[] args) {
		Keypad game = new RPGgame();

		game.leftUpButton();
		game.rightUpButton();
		game.changeMode();
		game.rightUpButton();
		game.rightDownButton();
		game.leftDownButton();
		game.changeMode();
		game.rightDownButton();

		System.out.println("===================");

		game = new ArcadeGame();
		game.leftUpButton();
		game.rightUpButton();
		game.leftDownButton();
		game.changeMode();
		game.rightUpButton();
		game.leftUpButton();
		game.rightDownButton();

	}

}
