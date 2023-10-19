package com.yedam.variable;

public class Variable03 {

	public static void main(String[] args) {
		int var1 = 0b1011; 	//2진수
		int var2 = 0206;	//8진수
		int var3 = 365;		//10진수
		int var4 = 0xB3;	//16진수
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		
		byte bVar1 = 125;
		int bVar2 = 200;
		
		System.out.println("bVar1: " + bVar1);
		System.out.println("bVar2: " + bVar2);
		//Long을 쓸때는 L을 붙여줘야 인식함
		long lVar1 = 2000000;
		long lVar2 = 20000000000L;
		
		//char
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		

	}

}
