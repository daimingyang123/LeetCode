package com.mingyangdai;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 17/4/7
 */
public class StringProblems {
	
	private HashSet<Character> first = new HashSet<Character>();
	private HashSet<Character> second = new HashSet<Character>();
	private HashSet<Character> third = new HashSet<Character>();
	
	public static void main(String[] args) {
		StringProblems problems = new StringProblems();
		String s = "adbcbcda";
		int result = problems.lengthOfLongestSubstring(s);
		System.out.println(result);
	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		List<Character> list = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			list.add(c);
		}
		Collections.sort(list);
		
		List<Character> list2 = new ArrayList<Character>();
		for (char c : t.toCharArray()) {
			list2.add(c);
		}
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).equals(list2.get(i))) return false;
		}
		
		return true;
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> target = new HashMap<Character, Integer>();
		for (char c : p.toCharArray()) {
//            target.put(c, target.getOrDefault(c, 0) + 1);
		}
		
		Map<Character, Integer> cur = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length() - 1; i++) {
//            cur.put(s.charAt(i), cur.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		int start;
		char c;
		for (int i = p.length() - 1; i < s.length(); i++) {
//            cur.put(s.charAt(i), cur.getOrDefault(s.charAt(i), 0) + 1);
			start = i - p.length() + 1;
			c = s.charAt(start);
			if (cur.equals(target)) result.add(start);
			if (cur.get(c) == 1) cur.remove(c);
			else cur.put(c, cur.get(c) - 1);
		}
		return result;
	}
	
	public boolean repeatedSubstringPattern(String s) {
		String p;
		boolean flag;
		int start;
		for (int length = 1; length <= s.length() / 2; length += 1) {
			flag = true;
			p = s.substring(0, length);
			for (start = length; start + length <= s.length(); start += length) {
				if (!s.substring(start, start + length).equals(p)) {
					flag = false;
					break;
				}
			}
			if (start == s.length() && flag) return true;
		}
		return false;
	}
	
	public String[] findWords(String[] words) {
		init();
		List<Character> result = new ArrayList<Character>();
		for (String word : words) {
//            if (findWords(word.toLowerCase())) result.add(word);
		}
		return result.toArray(new String[result.size()]);
	}
	
	private void init() {
		String line = "qwertyuiop";
		initMap(first, line);
		line = "asdfghjkl";
		initMap(second, line);
		line = "zxcvbnm";
		initMap(third, line);
	}
	
	private void initMap(HashSet<Character> set, String line) {
		for (char c : line.toCharArray()) {
			set.add(c);
		}
	}
	
	private boolean findWords(String word) {
		Set<Character> set = new HashSet<Character>();
		for (char c : word.toCharArray()) {
			set.add(c);
		}
		return first.containsAll(set) || second.containsAll(set) || third.containsAll(set);
	}
	
	public boolean detectCapitalUse(String word) {
		if (word.length() <= 1) return true;
		char[] array = word.toCharArray();
		
		if (Character.isUpperCase(array[0])) {
			if (word.length() == 2) return Character.isUpperCase(array[1]);
			
			if (Character.isUpperCase(array[1])) {
				for (int i = 2; i < array.length; i++) {
					if (!Character.isUpperCase(array[i])) return false;
				}
			} else {
				for (int i = 2; i < array.length; i++) {
					if (Character.isLowerCase(array[i])) return false;
				}
			}
			
		} else {
			for (int i = 1; i < array.length; i++) {
				if (Character.isUpperCase(array[i])) return false;
			}
		}
		
		return true;
	}
	
	public String reverseStr(String s, int k) {
		char[] array = s.toCharArray();
		if (s.length() < k) {
			reverse(array, 0, array.length - 1);
		} else {
			for (int i = 0; i < array.length; i += k) {
				reverse(array, i, i + k - 1);
			}
		}
		return new String(array);
	}
	
	private void reverse(char[] array, int start, int end) {
		char temp;
		while (start < end) {
			temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
	}

//    public int lengthOfLongestSubstring(String s) {
//        char[] array = s.toCharArray();
//        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
//        int max = 0;
//
//        for(int i=0; i<array.length; i++){
//            char cur = array[i];
//            if(!set.add(cur)){
//                max = Math.max(max, set.size());
//                LinkedHashSet<Character> next = new LinkedHashSet<Character>();
//                next.addAll(set);
//
//                for (Character c : set){
//                    next.remove(c);
//                    if (c == cur) break;
//                }
//                next.add(cur);
//                set = next;
//            }
//        }
//        max = Math.max(max, set.size());
//        return max;
//    }
	
	public int calculate(String s) {
		s = s.replace(" ", "");
		int num = 0;
		char oper = '+';
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else {
				switch (oper) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '*':
						stack.push(stack.pop() * num);
						break;
					case '/':
						stack.push(stack.pop() / num);
						break;
				}
				
				num = 0;
				oper = c;
			}
			if (i == s.length() - 1) stack.push(num);
		}
		
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		
		return result;
	}
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
