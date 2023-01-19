package com.yedam.java.ch02.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Database");
		set.add("iBATIS");
		boolean num = set.add("java");

		System.out.println(set);
		System.out.println(num);

		int size = set.size();
		System.out.println(size);
		System.out.println();

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {

			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println();
		set.remove("JDBC");
		set.remove("iBATIS");
		
		
		for(String skill : set) {
			System.out.println("\t"+skill);
		}

		set.clear();
		if(set.isEmpty()) {
			System.out.println("집에 갈래 보내줘 알게뭐야");
		}

	}

}
