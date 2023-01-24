package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11720 {

	public static void main(String[] args) throws IOException {
		// 버퍼 입력 객체 생성
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 숫자 개수 N 정의
		int N = Integer.parseInt(bf.readLine());
		// 입력값 ""기준으로 배열에 잘라서 저장
		String[] strAry = bf.readLine().split("");

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 각 배열 값 정수 변환 후 더하기
			sum += Integer.parseInt(strAry[i]);
		}
		System.out.println(sum);
	}
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		String str = sc.next();
//		String[] strAry = str.split("");
//		int sum = 0;
//		for (int i = 0; i < N; i++) {
//			 sum += Integer.parseInt(strAry[i]);
//		}
//		System.out.println(sum);

}
