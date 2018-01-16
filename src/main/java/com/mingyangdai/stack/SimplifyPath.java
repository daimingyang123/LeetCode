package com.mingyangdai.stack;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/11/18
 */
public class SimplifyPath {
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String s : path.split("/")) {
			switch (s) {
				case "" :
				case ".":
					break;
				case "..":
					if (!stack.isEmpty()) stack.pop();
					break;
				default:
					stack.push("/"+s);
					break;
			}
		}
		return String.join("", stack);
	}
	
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		String result = simplifyPath(path);
		System.out.printf(result);
//		String s = "hello";
//		List<String> elements = Lists.newArrayList("world", "oh", "ho");
//		String result = s.join(".", elements);
//		System.out.println(result);
	}
}
