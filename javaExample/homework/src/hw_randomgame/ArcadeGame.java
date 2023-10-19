package hw_randomgame;

public class ArcadeGame implements Keypad {
	// 필드
	private int currentMode = NORMAL_MODE;

	// 생성자
	public ArcadeGame() {
		System.out.println("Arcade Game 실행");
	}

	@Override
	public void leftUpButton() {
		// "캐릭터가 앞쪽으로 이동한다"를 출력한다.
		System.out.println("캐릭터가 앞쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		// "캐릭터가 뒤쪽으로 이동한다"를 출력한다.
		System.out.println("캐릭터가 뒤쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		// - NORMAL_MODE : "캐릭터가 일반 공격"를 출력한다.
		// - HARD_MODE : "캐릭터가 연속 공격"를 출력한다.
		if(currentMode == 0) {
			System.out.println("캐릭터가 일반 공격");
		} else if(currentMode == 1) {
			System.out.println("캐릭터가 연속 공격");
		}
	}

	@Override
	public void rightDownButton() {
		// - NORMAL_MODE : "캐릭터가 HIT 공격."를 출력한다.
		// - HARD_MODE : "캐릭터가 Double HIT 공격."를 출력한다.
		if(currentMode == 0) {
			System.out.println("캐릭터가 HIT 공격.");
		} else if(currentMode == 1) {
			System.out.println("캐릭터가 Double HIT 공격.");
		} 

	}

	@Override
	public void changeMode() {
		// 모드를 바꾸고 현재 모드를 출력하는 기능 
		if(currentMode == 0) {
			currentMode = 1;
			System.out.println("현재 모드 : HARD_MODE");
		} else if(currentMode == 1) {
			currentMode = 0;
			System.out.println("현재 모드 : NORMAL_MODE");
		} 
	}

}
