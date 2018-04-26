package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2018/4/1
 */
public class ExpressiveWords {
	
	public int expressiveWords(String S, String[] words) {
		int res = 0;
		if (S.length() == 0 || words.length == 0) return res;
		
		for (String word : words) {
			char[] sArray = S.toCharArray();
			char[] wArray = word.toCharArray();
			int i = 0, j = 0;
			boolean flag = true;
			
			while (i < sArray.length) {
				char s = sArray[i];
				char w = wArray[j];
				if (w != s) {
					flag = false;
					break;
				}
				
				int sCount = 0, wCount = 0;
				for (; i < sArray.length; i++) {
					if (sArray[i] == s) sCount++;
					else break;
				}
				for (; j < wArray.length; j++) {
					if (wArray[j] == w) wCount++;
					else break;
				}
				if (wCount > sCount || sCount < 3) {
					flag = false;
					break;
				}
			}
			if (flag && j == wArray.length) res++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String S = "heeellooo";
		String[] words = new String[]{"hello", "hi", "helo"};
		int res = new ExpressiveWords().expressiveWords(S, words);
		System.out.println(res);
	}
}
