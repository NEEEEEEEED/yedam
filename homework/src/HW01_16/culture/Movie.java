package HW01_16.culture;

public class Movie extends Culture {

	//필드
	public String genre;
	//생성자
	public Movie(String title, int directNum, int actorNum, String genre) {
		super(title, directNum, actorNum);
		this.genre = genre;
	}
	//메소드
	public abstract void getInformation()  {
		//제목, 참여감독 수, 참여배우 수, 관객수, 총점, 평점을 출력하는 기능
	}
}
