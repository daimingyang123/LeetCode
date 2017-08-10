package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/8/9
 */
public class CompareVersionNumbers {
	
	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2)) return 0;

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int length = Math.max(v1.length, v2.length);
		for (int i=0; i<length; i++) {
			String s1 = i < v1.length ? v1[i] : "0";
			Integer n1 = Integer.parseInt(s1);
			String s2 = i < v2.length ? v2[i] : "0";
			Integer n2 = Integer.parseInt(s2);
			if (n1.equals(n2)) continue;
			return n1.compareTo(n2);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String version1 = "15.0.1";
		String version2 = "15";
		CompareVersionNumbers numbers = new CompareVersionNumbers();
		int res = numbers.compareVersion(version1, version2);
		System.out.println(res);
	}
}
