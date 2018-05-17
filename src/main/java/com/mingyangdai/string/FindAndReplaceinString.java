package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2018/5/13
 */
public class FindAndReplaceinString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		String res = new String(S);
		for (int i = 0; i < indexes.length; i++) {
			int index = indexes[i];
			String source = sources[i];
			if (S.substring(index, index + source.length()).equals(source)) {
			
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String S = "abcd";
		int[] indexes = new int[]{0, 2};
		String[] sources = new String[]{"a", "cd"};
		String[] targets = new String[]{"eee", "ffff"};
		String res = new FindAndReplaceinString().findReplaceString(S, indexes, sources, targets);
		System.out.println(res);
	}
}
