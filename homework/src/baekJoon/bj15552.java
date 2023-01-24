package baekJoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj15552 {

	public static void main(String[] args) throws IOException {
		// bufferedReader 객체 안에 InputStreamReader 생성
		// br 입력 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// bw 출력 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트케이스 개수 선언
		// bufferedReader -> readLine()으로 읽음
		// String type으로 입력받기 때문에 정수로 파싱
		int N = Integer.parseInt(br.readLine());
		
		//StringTokenizer는 공백이 있다면 뒤에 문자열이 공백 자리를 땡겨 채우도록 한다.
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			//두 정수는 문자열 분리를 위해 매 반복마다 StringTokenizer 을 생성과 동시에 문자를 입력받는다.
			st = new StringTokenizer(br.readLine(), " ");
			// buffer는 줄이 바뀌거나 버퍼가 가득차면 보낸다(\n)
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		br.close();
		//버퍼를 비운 뒤(flush) 닫아줘야한다(close).
		bw.flush();
		bw.close();

	}
}
