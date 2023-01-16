package HW01_16.emp;

public class Employee {
	//필드
	public String name;
	public int payRoll;
	//생성자
	public Employee(String name,int payRoll) {
		this.name = name;
		this.payRoll = payRoll;
	}
	
	//메서드
	public void getInformation() {
		//이름과 연봉을 출력하는 기능
		System.out.println(name);
		System.out.println(payRoll);
	}
	public void print()  {
		//"수퍼클래스"란 문구를 출력하는 기능
		System.out.println("수퍼클래스");
	}
}
