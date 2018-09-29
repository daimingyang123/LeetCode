package com.mingyangdai.stack;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2018/9/22
 */
public class ExclusiveTimeofFunctions {
	
	public int[] exclusiveTime(int n, List < String > logs) {
		Stack < Integer > stack = new Stack < > ();
		int[] res = new int[n];
		String[] s = logs.get(0).split(":");
		stack.push(Integer.parseInt(s[0]));
		int i = 1, prev = Integer.parseInt(s[2]);
		while (i < logs.size()) {
			s = logs.get(i).split(":");
			if (s[1].equals("start")) {
				if (!stack.isEmpty())
					res[stack.peek()] += Integer.parseInt(s[2]) - prev;
				stack.push(Integer.parseInt(s[0]));
				prev = Integer.parseInt(s[2]);
			} else {
				res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
				stack.pop();
				prev = Integer.parseInt(s[2]) + 1;
			}
			i++;
		}
		return res;
	}
	
	public static void main(String args[]) {
		int n = 1;
		List<String> logs = Lists.newArrayList("0:start:0","1:start:2","1:end:5","0:end:6");
//		List<String> logs = Lists.newArrayList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
		int[] res = new ExclusiveTimeofFunctions().exclusiveTime(n, logs);
		System.out.println(res);
	}
}
