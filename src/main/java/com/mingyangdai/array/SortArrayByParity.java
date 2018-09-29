package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/9/16
 */
public class SortArrayByParity {
	
	public int[] sortArrayByParity(int[] A) {
		int start = 0, end = A.length - 1;
		while (start < end) {
			while (A[start] % 2 == 0) {
				start++;
			}
			while (A[end] % 2 == 1) {
				end --;
			}
			
			int t = A[start];
			A[start] = A[end];
			A[end] = t;
			
			start++;
			end--;
		}
		return A;
	}
	
	public static void main(String args[]) {
		int[] res = new SortArrayByParity().sortArrayByParity(new int[]{0,2});
		System.out.println(res);
	}
}
