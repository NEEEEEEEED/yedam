package com.yedam.variable;

public class OperatorCasting {

	public static void main(String[] args) {
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;
		
		long result = value1+value2+value3;
		System.out.println(result);
		
		//실수롸 정수 타입 변환 (연산)
		int intValue1 = 10;
		int intValue4 = intValue1/4;
		System.out.println(intValue4);
		
		int intValue2 = 10;
		double intValue3 = intValue2/4.0;
		System.out.println(intValue3);
		
		int x = 1;
		int y = 2;
		double result2 = x/y;
		System.out.println(result2);
		
		double result3 = x/(double)y;
		System.out.println(result3);
		
		//+ 연산
		//숫자 연산(+)
		int value = 10+2+8;
		System.out.println(value);
		
		//문자열 결합 연산
		String str1 = 10+2+"8";
		System.out.println("str1 : " + str1);
		
		String str2 = 10+"2"+8;
		System.out.println("str2 : " + str2);
		
		String str3 = "10"+2+8;
		System.out.println("str3 : " + str3);
		
		String str4 = "10" + (2+8);
		System.out.println("str4 : " + str4);
		
		//String <-> 정수, 실수 타입 변환
		int valueStr = Integer.parseInt(str4);
//		byte byteValue = Byte.parseByte(str4);
		short shortValue = Short.parseShort(str4);
		long longValue = Long.parseLong(str4);
		double dValue = Double.parseDouble(str4);
//		boolean bValue = Boolean.parseBoolean(str4);
		
		System.out.println(valueStr);
		System.out.println(shortValue);
		System.out.println(longValue);
		System.out.println(dValue);
		
		//int -> String
		String str5 = String.valueOf(valueStr);
		String str6 = String.valueOf(longValue);
		String str7 = String.valueOf(dValue);
		
		System.out.println(str5);
		System.out.println(str6);
		System.out.println(str7);
		
		
		
		

	}

}
