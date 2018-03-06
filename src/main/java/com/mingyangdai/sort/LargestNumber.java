package com.mingyangdai.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/3/5
 */
public class LargestNumber {
	
	public String largestNumber(int[] nums) {
		List<String> list = new ArrayList<>();
		for (int i : nums) {
			list.add(Integer.toString(i));
		}
		
		list.sort((o1, o2) -> {
			char[] array1 = (o1+o2).toCharArray();
			char[] array2 = (o2+o1).toCharArray();
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] == array2[i]) continue;
				return array2[i] - array1[i];
			}
			return 0;
		});
		
		StringBuilder res = new StringBuilder();
		for (String s : list) {
			res.append(s);
		}
		return res.charAt(0) == 0 ? "0" : res.toString();
	}
	
	public static void main(String[] args) {
		String res = new LargestNumber().largestNumber(new int[]{301, 30, 34, 5, 9});
		System.out.println(res);
	}
}
