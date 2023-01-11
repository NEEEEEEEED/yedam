package com.yedam.reference;

public class Reference {

	public static void main(String[] args) {
		int intVal = 10;
		int[] array = {1,2,3,4,5,6};
		int[] array2 = {1,2,3,4,5,6};
		int[] array3 = null;
		
		System.out.println(array);
		System.out.println(array2);
		System.out.println(array==array2);
		System.out.println(array[0]==array2[0]);
		System.out.println(intVal);
		System.out.println(array3[0]);
	}

}
