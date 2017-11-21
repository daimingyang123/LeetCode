package com.mingyangdai.stack;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/11/18
 */
public class SimplifyPath {
	public static String simplifyPath(String path) {
		String[] strings = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String s : strings) {
			if (s.equals("") || s.equals(".")) continue;
			if (s.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.push(s);
			}
		}
		return "/".join("/", stack);
	}
	
	public static void main(String[] args) {
//		String path = "/a/./b/../../c/";
//		String result = simplifyPath(path);
//		System.out.printf(result);
		String s = "hello";
		List<String> elements = Lists.newArrayList("world", "oh", "ho");
		String result = s.join(".", elements);
		System.out.println(result);
	}
}
