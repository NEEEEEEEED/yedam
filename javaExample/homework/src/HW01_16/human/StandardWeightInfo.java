package HW01_16.human;

public class StandardWeightInfo extends Human {
	// 필드
	public double sw;

	// 생성자
	public StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
		getStandardWeight();

	}

	// 메서드
	public double getStandardWeight() {
		// 표준체중을 구하는 기능
		return sw = (height - 100) * 0.9;

	}
	public void getInformation() {
		// 이름, 키, 몸무게와 표준체중을 출력하는 기능

		System.out.printf("%s님의 신장 %3.0f, 몸무게 %2.0f, 표준체중 %4.1f 입니다. \n", name, height, weight, sw);

	}

	
}
