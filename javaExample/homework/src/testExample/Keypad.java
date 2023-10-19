package testExample;

public interface Keypad {
	//상수필드
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	//추상메소드
	public abstract void leftUpButton();
	public abstract void leftDownButton();
	public abstract void rightUpButton();
	public abstract void rightDownButton();
	public abstract void changeMode();
}
