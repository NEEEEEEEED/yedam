package HW01_16.culture;

public class Culture {
	// 필드
	public String title;
	public int directNum;
	public int actorNum;
	public int audienceNum;
	public int total;

	// 생성자
	public Culture(String title, int directNum, int actorNum) {
		this.title = title;
		this.directNum = directNum;
		this.actorNum = actorNum;
	}

	// 메소드
	public void setTotalScore(int score) {
		// 관객수와 총점을 누적시키는 기능
		++audienceNum;
		++total;
	}

	public String getGrade() {
		// 평점을 구하는 기능
		
		
	}

	public abstract void getInformation() {
		//정보를 출력하는 추상메소드
	}
}
