package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/7/28
 */
public class RotateImage {
	
	public static void main(String[] args) {
		RotateImage image = new RotateImage();
		String s = " www seqing ";
		String res = image.reverseWords(s);
		System.out.println(res);
	}
	
	public void rotate(int[][] matrix) {
		List list = new ArrayList();
		list.add(1, 1);
		Queue queue = new LinkedList();
		Stack stack = new Stack();
		int step = matrix.length - 1;
		int level = matrix.length / 2;
		for (int i = 0; i < level; i++) {
			int tmp = matrix[0][matrix.length - 1];
			for (int j = 0; j < matrix.length; j++) {//j points per line
				for (int k = 0; k < matrix.length; k++) {//move one point k steps
					int x = 0, y;
					if (j + step > matrix.length - 1) {
						y = matrix.length - 1;
						x = j + step - matrix.length + 1;
					} else {
						y = j + step;
					}
					tmp = matrix[x][y];
					matrix[x][y] = matrix[0][j];
				}
			}
		}
	}
	
	public String reverseWords(String s) {
		String[] array = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i].isEmpty()) continue;
			res.append(array[i]);
			res.append(" ");
		}
		if (res.length() == 0) return res.toString();
		else return res.toString().substring(0, res.length() - 1);
	}
}
