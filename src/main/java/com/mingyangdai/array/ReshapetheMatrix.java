package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/25
 */
public class ReshapetheMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums.length == 0 || nums[0].length == 0) return nums;
		
		int row = nums.length;
		int col = nums[0].length;
		if (row*col != r*c) return nums;
		
		int[][] res = new int[r][c];
		int l= 0;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				row = l/col;
				col = l%col;
				res[i][j] = nums[row][col];
				l++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ReshapetheMatrix matrix = new ReshapetheMatrix();
		int[][] nums = {{1,2},{3,4}};
		int r = 1, c = 4;
		int[][] res = matrix.matrixReshape(nums, r, c);
		System.out.println(res);
	}
}
