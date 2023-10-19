package HW01_16.human;

public class ObesityInfo extends StandardWeightInfo {
	// 필드
	public double ob;

	// 생성자
	public ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);
		getObesity();

	}

	// 메서드
	public void getInformation() {
		// 이름, 키, 몸무게와 비만도를 출력하는 기능
		System.out.printf("%s님의 신장 %3.0f, 몸무게 %2.0f 비만입니다. \n", name, height, weight);
		
	}

	public double getObesity() {
		return ob = (weight - sw) / sw * 100;
	}
}
