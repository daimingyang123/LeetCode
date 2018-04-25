package com.mingyangdai.string;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2018/4/24
 */
public class SolvetheEquation {
	
	public String solveEquation(String equation) {
		char[] array = equation.toCharArray();
		Stack<String> left = new Stack<>(), right = new Stack<>();
		Stack<String> stack = left;
		int i = 0, j = 0;
		for (; j < array.length; j++) {
			switch (array[j]) {
				case '+':
				case '-':
					stack.push(equation.substring(i, j));
					i = j;
					break;
				case '=':
					stack.push(equation.substring(i, j));
					i = j + 1;
					stack = right;
					break;
			}
		}
		stack.push(equation.substring(i, j));
		
		int divisor = 0, dividend = 0;
		for (String s : left) {
			if (s.charAt(s.length() - 1) == 'x') {
				if (s.length() == 1) {
					divisor += 1;
				} else if (s.length() == 2) {
					if (s.charAt(0) == '+') divisor += 1;
					else if (s.charAt(0) == '-') divisor -= 1;
					else divisor += s.charAt(0) - '0';
				} else {
					divisor += Integer.parseInt(s.substring(0, s.length() - 1));
				}
			} else {
				dividend += Integer.parseInt(s);
			}
		}
		for (String s : right) {
			if (s.charAt(s.length() - 1) == 'x') {
				if (s.length() == 1) {
					divisor -= 1;
				} else if (s.length() == 2) {
					if (s.charAt(0) == '+') divisor -= 1;
					else if (s.charAt(0) == '-') divisor += 1;
					else divisor -= s.charAt(1) - '0';
				} else {
					divisor -= Integer.parseInt(s.substring(0, s.length() - 1));
				}
			} else {
				dividend -= Integer.parseInt(s);
			}
		}
		
		if (divisor == 0) return dividend == 0 ? "Infinite solutions" : "No solution";
		return "x=" + (-dividend / divisor);
	}
	
	public static void main(String[] args) {
		String res = new SolvetheEquation().solveEquation("-x=-1");
		System.out.println(res);
	}
}
