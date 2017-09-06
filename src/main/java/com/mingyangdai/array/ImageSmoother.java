package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/31
 */
public class ImageSmoother {
	
	public int[][] imageSmoother(int[][] M) {
		int[][] array = new int[M.length][M[0].length];
		
		for (int i=0; i<M.length; i++) {
			int sum = 0;
			for (int j=0; j<M[0].length; j++) {
				int rs = i-1 > 0 ? i-1 : 0;
				int re = i+1 < M.length ? i+1 : M.length-1;
				int cs = j-1 > 0 ? j-1 : 0;
				int ce = j+1 < M[0].length ? j+1 : M[0].length-1;
				
				if (j == 0) {
					sum = sum(M, rs, re, cs, ce);
				} else {
					int pre = j-2;
					if (pre >= 0) sum -= colSum(M, pre, rs, re);
					int next = j+1;
					if (next < M[0].length) sum += colSum(M, next, rs, re);
				}
				
				int count = (re-rs+1)*(ce-cs+1);
				array[i][j] = Math.floorDiv(sum, count);
			}
		}
		return array;
	}
	
	private int sum(int[][] array, int rs, int re, int cs, int ce) {
		int sum = 0;
		while (rs <= re) {
			int start = cs;
			while (start <= ce) {
				sum += array[rs][start++];
			}
			rs++;
		}
		return sum;
	}
	
	private int colSum(int[][] array, int col, int start, int end) {
		int sum = 0;
		while (start <= end) {
			sum += array[start++][col];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[][] array = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		ImageSmoother smoother = new ImageSmoother();
		int[][] res = smoother.imageSmoother(array);
		System.out.println(res);
	}
}
