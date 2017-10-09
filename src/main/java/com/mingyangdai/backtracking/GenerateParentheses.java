package com.mingyangdai.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/10/9
 */
public class GenerateParentheses {
	
	int n;
	List<String> res = null;
	
	public List<String> generateParenthesis(int n) {
		this.n = n;
		res = new ArrayList<>();
		generate(new StringBuilder(), 0, 0);
		return res;
	}
	
	private void generate(StringBuilder builder, int left, int right) {
		if (builder.length() == n*2) {
			res.add(builder.toString());
			return;
		}
		if (left < n) {
			builder.append("(");
			generate(builder, left+1, right);
			builder.deleteCharAt(builder.length()-1);
		}
		if (right < left) {
			builder.append(")");
			generate(builder, left, right+1);
			builder.deleteCharAt(builder.length()-1);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses parentheses = new GenerateParentheses();
		int n = 3;
		List<String> res = parentheses.generateParenthesis(n);
		System.out.println(res);
	}
}
