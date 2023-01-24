package baekJoon;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		//baekjoon10809
//		Scanner sc = new Scanner(System.in);
//		// a-z 담을 배열
//		int[] arr = new int[26];
//		//모든 배열에 -1 입력
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = -1;
//		}
//		// 비교할 문자열
//		String S = sc.nextLine();
//		// 문자열 char 변환 후 인덱스별 비교
//		for(int i = 0; i < S.length(); i++){
//			// 확인할 문자열 char 변환
//			char ch = S.charAt(i);
//			// 최초 위치에 숫자 변경을 위한 조건(초기값 -1과 비교)
//			if(arr[ch-97]==-1) {
//				//arr[ch - 97] 소문자 영어 위치, = i 비교할 문자열 S의 위치
//				arr[ch - 97] = i;
//			}
//		}
//		for(int i = 0; i<arr.length; i++) {
//			System.out.print(arr[i]+ " ");
//		}
		// baekjoon11720
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//		String str = sc.next();
//		String[] strAry = str.split("");
//		int sum = 0;
//
//		for (int i = 0; i < N; i++) {
//			 sum += Integer.parseInt(strAry[i]);
//		}
//		System.out.println(sum);
		
//		// baekjoon4344
//		Scanner sc = new Scanner(System.in);
//		// 테스트 케이스 개수 C 입력
//		int C = sc.nextInt();
//
//		// 각 케이스 만들기
//		for (int j = 0; j < C; j++) {
//			// 각 케이스 학생수 입력
//			int N = sc.nextInt();
//			int[] arr = new int[N];
//			double sumStd = 0;
//			// 각 학생수 성적 입력
//			for (int i = 0; i < N; i++) {
//				arr[i] = sc.nextInt();
//				// 각 케이스 학생 성적 총합
//				sumStd += arr[i];
//			}
//			// 각 케이스 학생 성적 평균
//			double avg = sumStd / N;
//			double count = 0;
//			// 평균 이상 학생의 수
//			for (int k = 0; k < arr.length; k++) {
//				if (avg < arr[k]) {
//					count++;
//				}
//			}
//			System.out.printf("%.3f%%\n", (count / N) * 100);
//		}

		// baekjoon2439

//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//		// 줄의 개수
//		for (int i = 1; i < N + 1; i++) {
//			// N-1 공백의 개수
//			for (int j = 0; j < N - i; j++) {
//				System.out.print(" ");
//			}
//			// i번째 줄의 별의 개수
//			for (int k = 0; k < i; k++) {
//				System.out.print("*");
//			}
//			// 별찍고 줄바꿈
//			System.out.print("\n");
//		}

		// baekjoon2739
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		
//		for (int i = 1; i <= 9; i++) {
//				 System.out.printf("%d * %d = %d\n",N,i,(N*i));
//			
//		}

		// baekjoon15552
//		문제
//		본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 
//		시간초과가 날 수 있다는 점이다.
//		Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. 
//		BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
//
//		또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 
//		테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
//
//		자세한 설명 및 다른 언어의 경우는 이 글에 설명되어 있다.
//
//		이 블로그 글에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.
//
//		입력
//		첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. 
//		A와 B는 1 이상, 1,000 이하이다.
//
//		출력
//		각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.

		// baekjoon10818
//		문제
//		N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
//		모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
//
//		출력
//		첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		
//		for(int i = 0 ; i<N; i ++) {
//			 arr[i] = sc.nextInt();
//		}
//		
//		int max = arr[0];
//		int min = arr[0];
//		
//		for(int i = 0 ; i<N; i ++) {
//			if(arr[i] > max) {
//				max = arr[i];
//			}
//			if(arr[i] < min) {
//				min = arr[i];
//			}
//			
//		}
//		System.out.printf("%d %d",min,max);

		// baekjoon10871
//		문제
//		정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
//
//		둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
//
//		출력
//		X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int X = sc.nextInt();
//		int[] intArr = new int[N];
//		//배열 N개 만큼 숫자 넣기
//		for(int i = 0; i <N ; i++) {
//			intArr[i] = sc.nextInt();
//		}
//		//숫자 비교
//		for(int i = 0 ; i< N; i++) {
//			if(intArr[i] < X) {
//				System.out.print(intArr[i] + " ");
//			}
//		}

		// baekjoon2525
//		KOI 전자에서는 건강에 좋고 맛있는 훈제오리구이 요리를 간편하게 만드는 인공지능 오븐을 개발하려고 한다. 
//		인공지능 오븐을 사용하는 방법은 적당한 양의 오리 훈제 재료를 인공지능 오븐에 넣으면 된다. 
//		그러면 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다. 
//
//		또한, KOI 전자의 인공지능 오븐 앞면에는 사용자에게 훈제오리구이 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다. 
//
//		훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때, 
//		오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 
//		정수로 빈칸을 사이에 두고 순서대로 주어진다. 
//		두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다. 
//
//		출력
//		첫째 줄에 종료되는 시각의 시와 분을 공백을 사이에 두고 출력한다. (단, 시는 0부터 23까지의 정수, 
//		분은 0부터 59까지의 정수이다. 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)
//		Scanner sc = new Scanner(System.in);
//
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//
//		int C = sc.nextInt();
//		// 모두 분으로 바꿈
//		int min = 60 * A + B; // 시 -> 분
//		min += C;
//		// A B C를 더한 분을 시와 분으로 나눔
//		int hour = (min / 60) % 24;
//		int minute = min % 60;
//
//		System.out.println(hour + " " + minute);

		// beakjoon2742
//		문제
//		자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
//
//		출력
//		첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
//		Scanner sc = new Scanner(System.in);
//		int N = Integer.parseInt(sc.nextLine());
//		
//		for(int i = N; i > 0; i-- ) {
//			System.out.println(i);
//		}
//		

		// baekjoon1924
//		문제
//		오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 
//		이를 알아내는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다. 
//		참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 
//		2월은 28일까지 있다.
//
//		출력
//		첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.

//		Scanner sc = new Scanner(System.in);
//		
		// x 월, y일
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		
//		Calendar now = Calendar.getInstance();

		// set메소드 월은 0부터 1월 시작 조심
//		now.set(2007, x-1, y);
//		
//		int week = now.get(Calendar.DAY_OF_WEEK);
//		String strWeek = null;
//		switch(week) {
//		case Calendar.MONDAY :
//			strWeek = "MON";
//			break;
//		case Calendar.TUESDAY :
//			strWeek = "TUE";
//			break;
//		case Calendar.WEDNESDAY :
//			strWeek = "WED";
//			break;
//		case Calendar.THURSDAY :
//			strWeek = "THU";
//			break;
//		case Calendar.FRIDAY :
//			strWeek = "FRI";
//			break;
//		case Calendar.SATURDAY :
//			strWeek = "SAT";
//			break;
//		case Calendar.SUNDAY :
//			strWeek = "SUN";
//			break;	
//		}
//		System.out.println(strWeek);

		// baekjoon2884
//		문제
//		상근이는 매일 아침 알람을 듣고 일어난다. 알람을 듣고 바로 일어나면 다행이겠지만, 
//		항상 조금만 더 자려는 마음 때문에 매일 학교를 지각하고 있다.
//		상근이는 모든 방법을 동원해보았지만, 조금만 더 자려는 마음은 그 어떤 것도 없앨 수가 없었다.
//		이런 상근이를 불쌍하게 보던, 창영이는 자신이 사용하는 방법을 추천해 주었다.
//		바로 "45분 일찍 알람 설정하기"이다.
//		이 방법은 단순하다. 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것이다. 
//		어차피 알람 소리를 들으면, 알람을 끄고 조금 더 잘 것이기 때문이다. 이 방법을 사용하면, 
//		매일 아침 더 잤다는 기분을 느낄 수 있고, 학교도 지각하지 않게 된다.
//		현재 상근이가 설정한 알람 시각이 주어졌을 때, 창영이의 방법을 사용한다면, 
//		이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 
//		이것은 현재 상근이가 설정한 놓은 알람 시간 H시 M분을 의미한다.
//
//		입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 
//		끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
//
//		출력
//		첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다. 
//		입력과 같은 형태로 출력하면 된다.)

//		Scanner sc = new Scanner(System.in);
//		
//		int H = sc.nextInt();
//		int M = sc.nextInt();
//		
//		if (M >= 45) {
//			System.out.println(H + " " + (M-45));
//		} else {
		// 시간에서 1시간 빼고
//			H--;
		// 분에 60분 추가
//			M = 60 + M - 45;
		// 0시일 경우 음수가 나옴으로 23시로 가야됨
//			if(H<0) {
//				H = 23;
//			}
//			System.out.println(H + " " + M);
//		}

		// baekjoon1330
//		문제
//		두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
//
//		출력
//		첫째 줄에 다음 세 가지 중 하나를 출력한다.
//
//		A가 B보다 큰 경우에는 '>'를 출력한다.
//		A가 B보다 작은 경우에는 '<'를 출력한다.
//		A와 B가 같은 경우에는 '=='를 출력한다.

//		Scanner sc = new Scanner(System.in);
//
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		if (A > B) {
//			System.out.println(">");
//		} else if (A < B) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}

		// baekjoon 10430
//		문제
//		(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
//		(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
//		세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
//
//		출력
//		첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

//		Scanner sc = new Scanner(System.in);
//		//nextLine()은 한줄로 입력이 불가능, String 값으로 읽음
//		//nextInt() 한줄로 표현 가능(공백 인식 안하는듯?),parseInt 필요 없음
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		int C = sc.nextInt();
//
//		System.out.println((A + B) % C);
//		System.out.println(((A % C) + (B % C)) % C);
//		System.out.println((A * B) % C);
//		System.out.println(((A % C) * (B % C)) % C);

	}
}