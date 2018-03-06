package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/3/2
 */
public class MaximumProductSubarray {
	int maxProduct(int A[], int n) {
		// store the result that is the max we have found so far
		int r = A[0];
		
		// imax/imin stores the max/min product of
		// subarray that ends with the current number A[i]
		for (int i = 1, imax = r, imin = r; i < n; i++) {
			// multiplied by a negative makes big number smaller, small number bigger
			// so we redefine the extremums by swapping them
			if (A[i] < 0) {
				int t = imax;
				imax = imin;
				imin = t;
			}
			
			// max/min product for the current number is either the current number itself
			// or the max/min by the previous number times the current one
			imax = Math.max(A[i], imax * A[i]);
			imin = Math.min(A[i], imin * A[i]);
			
			// the newly computed max value is a candidate for our global result
			r = Math.max(r, imax);
		}
		return r;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,-2,4};
		int res = new MaximumProductSubarray().maxProduct(A, A.length);
		System.out.println(res);
	}
}
