package HW01_16.human;

public class Human {
	//필드
	public String name;
	public double height;
	public double weight;
	//생성자
	public Human() {
		
	}
	public Human(String name,double height,double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	//메서드
	public void getInformation() {
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
	}
}
