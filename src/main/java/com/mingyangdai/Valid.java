package com.mingyangdai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mingyang.dai
 * @since 17/3/10
 */
public class Valid {
	
	public static void main(String[] args) {
		Valid valid = new Valid();
		String s = "11223344567";
		System.out.println(valid.isValid(s));
	}
	
	public String isValid(String s) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(5);
		set.add(8);
		set.add(11);
		set.add(14);
		if (!set.contains(s.length())) return "no";
		
		int ke = 0, shun = 0, dui = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				if (map.get(c) > 4) return "no";
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			switch (entry.getValue()) {
				case 2:
					dui += 1;
					map.remove(entry.getKey());
					break;
				case 3:
					ke += 1;
					map.remove(entry.getKey());
					break;
			}
		}
		
		if (dui == 3) {
		
		}
		return "";
	}
}
