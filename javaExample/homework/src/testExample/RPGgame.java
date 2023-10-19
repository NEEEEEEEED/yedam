package testExample;

public class RPGgame implements Keypad {
	private int currentMode;
	
	public RPGgame() {
		this.currentMode = Keypad.NORMAL_MODE;
		System.out.println("PRGgame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		switch (this.currentMode) {
		case Keypad.NORMAL_MODE:
			System.out.println("캐릭터가 한칸단위로 점프한다.");
			break;
		case Keypad.HARD_MODE:
			System.out.println("캐릭터가 두칸단위로 점프한다.");
			break;
		}
	}

	@Override
	public void rightDownButton() {
		switch (this.currentMode) {
		case Keypad.NORMAL_MODE:
			System.out.println("캐릭터가 일반 공격.");
			break;
		case Keypad.HARD_MODE:
			System.out.println("캐릭터가 HIT 공격.");
			break;
		}
	}

	@Override
	public void changeMode() {
		switch (this.currentMode) {
		case Keypad.NORMAL_MODE:
			this.currentMode = Keypad.HARD_MODE;
			System.out.println("현재 모드 : HARD_MODE");
			break;
		case Keypad.HARD_MODE:
			this.currentMode = Keypad.NORMAL_MODE;
			System.out.println("현재 모드 : NORMAL_MODE");
			break;
		}

	}

}
