package test04;

public class Test04Example {

	public static void main(String[] args) {
		String[] arr = { "010102-4", "991012-1", "960304-1", "881012-2", "040403-3" };
		int male = 0;
		int female = 0;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i].charAt(arr[i].length()-1) == '1'||arr[i].charAt(arr[i].length()-1) == '3') {
				male++;
			} else if(arr[i].charAt(arr[i].length()-1) == '2'||arr[i].charAt(arr[i].length()-1) == '4') {
				female++;
			}
		}

		System.out.printf("남 %d 여 %d",male,female);

	}

}
