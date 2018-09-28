package com.mingyangdai.bitmanipulation;

/**
 * @author mingyang.dai
 * @since 2018/7/15
 */
public class ReorderedPowerof2 {
	public boolean reorderedPowerOf2(int N) {
		char[] array = Integer.toString(N).toCharArray();
		return permutation(array, new boolean[array.length], new StringBuilder());
	}
	
	public boolean permutation(char[] array, boolean[] visited, StringBuilder cur) {
		if (cur.length() == array.length) {
			int n = Integer.parseInt(cur.toString());
			return (n & (n-1)) == 0;
		}
		for (int i = 0; i < array.length; i++) {
			if (visited[i]) continue;
			if (i > 0 && array[i] == array[i-1] && visited[i-1]) continue;
			cur.append(array[i]);
			visited[i] = true;
			boolean res = permutation(array, visited, cur);
			if (res) return true;
			cur.deleteCharAt(cur.length() - 1);
			visited[i] = false;
		}
		return false;
	}
	
	public static void main(String args[]) {
		
	}
}
