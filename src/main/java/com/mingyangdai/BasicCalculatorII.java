package com.mingyangdai;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/6/26
 */
public class BasicCalculatorII {
	private int start = 0;
	
	public static void main(String[] args) {
		BasicCalculatorII calculator = new BasicCalculatorII();
		String s = "";
		int result = calculator.calculate(s);
		System.out.println(result);
	}
	
	public int calculate(String s) {
		s = s.replace(" ", "");
		Stack<String> stack = new Stack<String>();
		String pre, con, cur, temp;
		
		s = "+" + s;
		while (start < s.length()) {
			con = s.substring(start, ++start);
			cur = getDigit(s);
			if (isHigh(con)) {
				pre = stack.pop();
				temp = calculate(pre, cur, con);
				stack.push(temp);
			} else {
				stack.push(con);
				stack.push(cur);
			}
		}
		
		String result = "0";
		while (!stack.isEmpty()) {
			cur = stack.pop();
			con = stack.pop();
			result = calculate(result, cur, con);
		}
		
		return Integer.parseInt(result);
	}
	
	private String getDigit(String s) {
		int temp = start++;
		char c;
		while (start < s.length()) {
			c = s.charAt(start);
			if (!Character.isDigit(c)) {
				return s.substring(temp, start);
			}
			start++;
		}
		return s.substring(temp, s.length());
	}
	
	private boolean isHigh(String oper) {
		return oper.equals("*") || oper.equals("/");
	}
	
	private String calculate(String pre, String cur, String con) {
		int first = Integer.parseInt(pre);
		int second = Integer.parseInt(cur);
		char oper = con.toCharArray()[0];
		int result = 0;
		switch (oper) {
			case '+':
				result = first + second;
				break;
			case '-':
				result = first - second;
				break;
			case '*':
				result = first * second;
				break;
			case '/':
				result = first / second;
				break;
		}
		return Integer.toString(result);
	}
}
