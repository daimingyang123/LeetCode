package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/8/9
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split(".");
		String[] s2 = version2.split(".");
		int length = Math.min(s1.length, s2.length);
		for (int i=0; i<length; i++) {
			int n1 = Integer.parseInt(s1[i]);
			int n2 = Integer.parseInt(s1[i]);
			if(n1 > n2) return 1;
			if(n1 < n2) return -1;
		}
		if(s1.length == s2.length) return 0;
		return s1.length > s2.length ? 1 : -1;
	}
}
