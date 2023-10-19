package com.yedam.java.ch03.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("보내줘", 82);
		map.put("집에", 82);
		map.put("ㅠㅠ", 1111);
		map.put("ㅠㅠ", 123);
		
		System.out.println(map.size());
		System.out.println(map.get("ㅠㅠ"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		for(String name : keySet) {
			int score = map.get(name);
			System.out.println(name +":" +score);
			
		}
		System.out.println();
		map.remove("ㅠㅠ");
		System.out.println(map.size());
		System.out.println();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		System.out.println(entryIterator);
		
		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next()
;
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + value);}
		
		
		
		
	}

}
