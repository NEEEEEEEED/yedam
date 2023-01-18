package com.yedam.java.ch03.string;

public class SubStringExample {

	public static void main(String[] args) {
		String ssn = "880815 1234567";
		
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		String lastNum = ssn.substring(7);
		System.out.println(lastNum);
		
		String[] numList = ssn.split(" ");
		for(String num : numList) {
			System.out.println(num);
		}
		
	}

}
