package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/7/28
 */
public class RotateImage {
	
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int i = 0; i < length/2; i++) {
			for (int j = 0; j < length; j++) {
				int tmp = matrix[i][j];
				int op = length-1-i;
				matrix[i][j] = matrix[op][j];
				matrix[op][j] = tmp;
			}
		}
		
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j < length; j++) {
				if (i >= j) continue;
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		RotateImage image = new RotateImage();
		int[][] matrix = {
				{5,1,9,11},
				{2,4,8,10},
				{13,3,6,7},
				{15,14,12,16}
		};
		image.rotate(matrix);
		System.out.println(matrix);
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
