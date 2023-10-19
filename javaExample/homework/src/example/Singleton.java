package example;

public class Singleton {
	// 싱글톤
	// 프로그램 내에서 단 하나의 객체를 보장.
	// java<=>db 연결 -> 연결 담당자 1명 지정 (script에서 pool 한것)
	// springframe에서 사용
	
	//외부 접근 불가 객체 형태(힙영역에 등록 안됨)
	private static Singleton singleton = null;
	//싱글톤 조건1.생성자 private => 외부에서 Singleton 객체 생성 불가
	private Singleton() {
		
	}
	//싱글톤 조건2.외부에서 Singleton 내부에서 만든 객체 연결 메소드
	public static Singleton getInstance() {
		//힙영역에 등록이 안됐다면
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
