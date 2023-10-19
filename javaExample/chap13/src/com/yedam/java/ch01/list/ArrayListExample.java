package com.yedam.java.ch01.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		//java, JDBC, Database, Servlet/JSP, iBATIS
		//값 중복 허용
		list.add("java");
		int size = list.size();
		System.out.println(size);
		System.out.println();
		
		System.out.println(list);
		String skill = list.get(2);
		System.out.println(skill);
		
		for(int i = 0; i < list.size();i++) {
			System.out.printf("%d : %s\n", i , list.get(i));
		}
		
		System.out.println();
		
		list.remove(2);	//Database
		list.remove(2); //Servlet/JSP
		list.remove("java"); //첫 java를 삭제하고 기능 종료 
		
		for(String data : list) {
			System.out.println(data);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
