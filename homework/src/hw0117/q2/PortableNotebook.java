package hw0117.q2;

public class PortableNotebook implements Notebook, Tablet {
	// 필드
	private int mode = 1;
	private String document;
	private String browser;
	private String video;
	private String app;

	// 생성자
	public PortableNotebook(String document, String browser, String video, String app) {
		this.document = document;
		this.browser = browser;
		this.video = video;
		this.app = app;
		System.out.println("NOTEBOOK_MODE");
	}

	@Override
	public void writeDocumentation() {
		// : "'문서 프로그램'을 통해 문서를 작성."을 출력한다.
		System.out.println(document + "을 통해 문서를 작성.");

	}

	@Override
	public void useApp() {
		// - NOTEBOOK_MODE : 현재 모드를 바꾸고 "'앱종류'를 실행."를 출력한다.
		// - TABLET_MODE : "'앱종류'를 실행."을 출력한다.
		if (mode == 1) {
			mode = 2;
			System.out.println("TABLET_MODE");
			System.out.println(app + "를 실행.");
		} else if (mode == 2) {
			mode = 1;
			System.out.println("NOTEBOOK_MODE");
			System.out.println(app + "를 실행.");
		}
	}

	@Override
	public void watchVideo() {
		// "'영상종류'를 시청."을 출력한다.
		System.out.println(video + "를 시청.");
	}

	@Override
	public void searchInternet() {
		// "'인터넷 브라우저'를 통해 인터넷을 검색."을 출력한다.
		System.out.println(browser + "를 통해 인터넷을 검색.");
	}

	public void changeMode() {
		// 모드를 바꾸고 현재 모드를 출력하는 기능
		if (mode == 1) {
			mode = 2;
			System.out.println("NOTEBOOK_MODE");
		} else if (mode == 2) {
			mode = 1;
			System.out.println("TABLET_MODE");
		}
	}

}
