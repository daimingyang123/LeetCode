package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/8/12
 */
public class SpiralMatrixIII {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] res = new int[R*C][1];
		res[0] = new int[]{r0, c0};
		
		int[] x = new int[]{1, 0, -1, 0};
		int[] y = new int[]{0, -1, 0, 1};
		int i = 1, z = 1;
		
		while (i < R*C) {
			for (int j = 0; j < 4;) {
				for (int k = 0; k < 2; k++, j++) {
					for (int l = 0; l < z; l++) {
						r0 += x[j];
						c0 += y[j];
						if (r0 >=0 && r0 < R && c0 >=0 && c0 < C) {
							res[i++] = new int[]{r0, c0};
						}
					}
				}
				z++;
			}
		}
		
		return res;
	}
	
	
	public static void main(String args[]) {
		int[][] res = new SpiralMatrixIII().spiralMatrixIII(5, 6, 1, 4);
		System.out.println(res);
	}
}
