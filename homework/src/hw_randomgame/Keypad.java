package hw_randomgame;

public interface Keypad {
	//필드
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	//메서드
	public void leftUpButton();
	//: 왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public void leftDownButton();
	//: 왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public void rightUpButton();
	//: 오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public void rightDownButton() ;
	//: 오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public void changeMode() ;
	//: 모드를 바꾸고 현재 모드를 출력하는 기능 ( NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
}
