package hw0117.q2;

public class NoteExample {

	public static void main(String[] args) {
		PortableNotebook pn = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드앱");
		pn.writeDocumentation();
		pn.watchVideo();
		pn.useApp();
		pn.searchInternet();

	}

}
