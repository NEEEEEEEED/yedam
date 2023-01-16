package HW01_16.emp;

public class EmpDept extends Employee {
	// 필드
	private String departmentName;

	// 생성자
	public EmpDept(String name, int payRoll, String departmentName) {
		super(name, payRoll);
		this.departmentName = departmentName;
	}

	// 메서드
	
	public String getDepartmentName() {
		return departmentName;
	}
	@Override
	public void getInformation() {
		// 이름과 연봉, 부서를 출력하는 기능
		System.out.printf("이름:%s 연봉:%d 부서:%s \n", name, payRoll,departmentName);
	}

	public void print() {
		// "수퍼클래스\n서브클래스"란 문구를 출력하는 기능
		System.out.println("수퍼클래스\n서브클래스");
	}
}
