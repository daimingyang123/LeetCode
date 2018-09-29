package com.mingyangdai.stack;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2018/9/28
 */
public class DecodeString {
	public String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
				case ']':
					StringBuilder builder = new StringBuilder();
					while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
						builder.append(stack.pop());
					}
					stack.pop();
					
					StringBuilder num = new StringBuilder();
					while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
						num.append(stack.pop());
					}
					int count = num.length() == 0 ?
							0 : Integer.parseInt(num.reverse().toString());
					
					pushRepeat(stack, builder.toString(), count);
					break;
				default:
					stack.push(c);
					break;
			}
		}
		
		char[] array = new char[stack.size()];
		for (int i = array.length - 1; i >=0; i--) {
			array[i] = stack.pop();
		}
		return new String(array);
	}
	
	private void pushRepeat(Stack<Character> stack, String s, int count) {
		char[] array = s.toCharArray();
		for (int i = 0; i < count; i++) {
			for (int j = array.length - 1; j >= 0; j--) {
				stack.push(array[j]);
			}
		}
	}
	
	public static void main(String args[]) {
		String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		String res = new DecodeString().decodeString(s);
		System.out.println(res);
	}
}
