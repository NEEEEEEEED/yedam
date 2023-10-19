package hw_randomgame;

public class RPGgame implements Keypad {
	// 필드
	private int currentMode = NORMAL_MODE;

	// 생성자
	public RPGgame() {
		System.out.println("RPG game 실행");
	}

	@Override
	public void leftUpButton() {
		// "캐릭터가 위쪽으로 이동한다"를 출력한다.
		System.out.println("캐릭터가 위쪽으로 이동한다");

	}

	@Override
	public void leftDownButton() {
		// "캐릭터가 아래쪽으로 이동한다"를 출력한다.
		System.out.println("캐릭터가 아래쪽으로 이동한다");

	}

	@Override
	public void rightUpButton() {
		// - NORMAL_MODE : "캐릭터가 한칸단위로 점프한다."를 출력한다.
		// - HARD_MODE : "캐릭터가 두칸단위로 점프한다."를 출력한다.
		if (currentMode == 0) {
			System.out.println("캐릭터가 한칸단위로 점프한다.");
		} else if (currentMode == 1) {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}

	}

	@Override
	public void rightDownButton() {
		// - NORMAL_MODE : "캐릭터가 일반 공격."를 출력한다.
		// - HARD_MODE : "캐릭터가 HIT 공격."를 출력한다.
		if (currentMode == 0) {
			System.out.println("캐릭터가 일반 공격.");
		} else if (currentMode == 1) {
			System.out.println("캐릭터가 HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		// 모드를 바꾸고 현재 모드를 출력하는 기능
		if (currentMode == 0) {
			currentMode = 1;
			System.out.println("현재 모드 : HARD_MODE");
		} else if (currentMode == 1) {
			currentMode = 0;
			System.out.println("현재 모드 : NORMAL_MODE");
		}

	}

}
