package com.mingyangdai.treemap;

import java.util.Stack;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/11/18
 */
public class DIStringMatch {
	
	public int[] diStringMatch(String S) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 1; i <= S.length(); i++) {
			set.add(i);
		}
		
		for (char c : S.toCharArray()) {
			if (c == 'I') {
				int h = set.higher(stack.peek());
				stack.push(h);
				set.remove(h);
			} else {
				int i = stack.pop();
				int h = set.higher(i);
				stack.push(h);
				set.remove(h);
				stack.push(i);
			}
		}
		
		int[] res = new int[stack.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}
	
	public static void main(String args[]) {
		String S = "IDID";
		int[] res = new DIStringMatch().diStringMatch(S);
		System.out.println(res);
	}
}
