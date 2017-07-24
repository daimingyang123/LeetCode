package com.mingyangdai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
	
	public static void main(String[] args) {
		App app = new App();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		int result = app.minimumTotal(list);
		System.out.println(result);
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] oldLine = new int[1];
		oldLine[0] = triangle.get(0).get(0);
		List<Integer> cur;
		
		for (int i = 1; i < triangle.size(); i++) {
			cur = triangle.get(i);
			int[] newLine = new int[cur.size()];
			for (int j = 0; j < cur.size(); j++) {
				if (j == 0) {
					newLine[0] = oldLine[0] + cur.get(0);
				} else if (j == cur.size() - 1) {
					newLine[j] = oldLine[j - 1] + cur.get(j);
				} else {
					newLine[j] = Math.min(oldLine[j - 1], oldLine[j]) + cur.get(j);
				}
			}
			oldLine = newLine;
		}
		
		Arrays.sort(oldLine);
		return oldLine[0];
	}
}
