package com.yedam.object;

import java.util.Calendar;

public class CalculatorTest {

	public static void main(String[] args) {
//		Calculator calc = new Calculator();
//		int result = calc.sum(10, 20);
//		System.out.println(result);
//		
//		Calculator calc1 = new Calculator();
//		int result1 = calc.sum(10, 20);
//		System.out.println(result1);
//		
//		System.out.println(calc == calc1);
		
		CalculatorSingle calcSingle = CalculatorSingle.getInstance();
		CalculatorSingle calcSingle1 = CalculatorSingle.getInstance();
		System.out.println(calcSingle == calcSingle1);
		
		Calendar today = Calendar.getInstance();//싱글톤
		today.set(2023,2,1);
		System.out.println(today.get(Calendar.DAY_OF_YEAR));
		
		
	}

}
