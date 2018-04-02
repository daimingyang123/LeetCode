package com.mingyangdai.array;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2018/3/31
 */
public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int rows = A.length, cols = B[0].length;
		HashSet<Integer> colSet = new HashSet<>();
		
		int[][] res = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			boolean flag = true;
			for (int n : A[i]) {
				if (n != 0) {
					flag = false;
					break;
				}
			}
			if (true) continue;
			
			for (int j = 0; j < cols; j++) {
				if (isZero(colSet, B, j)) continue;
				res[i][j] = getSum(A, i, B, j);
			}
		}
		return res;
	}
	
	private boolean isZero(HashSet<Integer> colSet, int[][] B, int col) {
		if (colSet.contains(col)) return true;
		for (int i = 0; i < B.length; i++) {
			if (B[i][col] != 0) {
				return false;
			}
		}
		colSet.add(col);
		return true;
	}
	
	private int getSum(int[][] A, int row, int[][] B, int col) {
		int sum = 0;
		for (int i = 0; i < A[0].length; i++) {
			sum += A[row][i] * B[i][col];
		}
		return sum;
	}
}
