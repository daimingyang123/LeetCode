package com.mingyangdai.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/3/14
 */
public class RemoveComments {
	public List<String> removeComments(String[] source) {
		// 666 /*
		List<String> res = new ArrayList<>();
		
		if (source == null || source.length == 0) return res;
		
		boolean isClosed = true;
		for (String s : source) {
			int comment = s.indexOf("//");
			int open = s.indexOf("/*");
			int close = s.lastIndexOf("*/");
			
			if (comment < 0 && open < 0 && close < 0) {
				if (isClosed) res.add(s);
				continue;
			}
			
			String cur = "";
			if (close > 0 && !isClosed) {
				isClosed = true;
				cur = close+2 < s.length() ? s.substring(close+2) : cur;
				if (res.size() != 0) cur = res.remove(res.size()-1) + cur;
			} else if (open > comment) {
				cur = s.substring(0, open);
				if (close > 0) {
					cur = close+2 < s.length() ? cur+s.substring(close+2) : cur;
				} else {
					isClosed = false;
				}
			} else if (comment > open) {
				cur = s.substring(0, comment);
			}
			
			if (!cur.isEmpty()) res.add(cur);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
//		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//		String[] source = {"a/*comment", "line", "more_comment*/b"};
		String[] source = {"void func(int k) {","// this function does nothing /*","   k = k*2/4;","   k = k/2;*/","}"};
		List<String> res = new RemoveComments().removeComments(source);
		System.out.println(res);
	}
}
