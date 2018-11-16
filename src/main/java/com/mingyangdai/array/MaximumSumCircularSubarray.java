package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/10/21
 */
public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] A) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			int j = i, pre = 0;
			for (; j < i + A.length; j++) {
				int k = j % A.length;
				if (pre < 0) {
					pre = A[k];
					max = Math.max(max, pre);
					i = j - 1;
					break;
				} else {
					pre += A[k];
					max = Math.max(max, pre);
				}
			}
		}
		return max;
	}
	
	public static void main(String args[]) {
		int[] A = {5,-3,5};
		int res = new MaximumSumCircularSubarray().maxSubarraySumCircular(A);
		System.out.println(res);
	}
}
