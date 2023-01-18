package com.yedam.java.ch01.object;

import java.util.HashMap;
import java.util.Map;

public class Example {

	public static void main(String[] args) {
		Member m1 = new Member("배고파");
		Member m2 = new Member("보내줘");
		Member m3 = new Member("보내줘");

		if (m1 == m2) {
			System.out.println("m1과 m2는 동등합니다.");
		} else {
			System.out.println("m1과 m2는 동등하지 않습니다.");
		}
		if (m2 == m3) {
			System.out.println("m2과 m3는 동등합니다.");
		} else {
			System.out.println("m2과 m3는 동등하지 않습니다.");
		}
		if (m1.equals(m2)) {
			System.out.println("m1과 m2는 동등합니다.");
		} else {
			System.out.println("m1과 m2는 동등하지 않습니다.");
		}
		if (m2.equals(m3)) {
			System.out.println("m2과 m3는 동등합니다.");
		} else {
			System.out.println("m2과 m3는 동등하지 않습니다.");
		}

		Map<Key, String> hashMap = new HashMap<Key, String>();
		hashMap.put(new Key(1), "잠온다");
		
		String name = hashMap.get(new Key(1));
		System.out.println(name);
		
		System.out.println();
		
		String message = "오늘은 수요일입니다.";
		System.out.println(message);
		System.out.println(m1);
		
		
		
		

	}

}
