package HW01_16.human;

public class HumanExample {

	public static void main(String[] args) {
	Human human = new StandardWeightInfo("홍길동", 168, 45);
	human.getInformation();
	human = new ObesityInfo("박둘이", 168, 90);
	human.getInformation();
	}

}
