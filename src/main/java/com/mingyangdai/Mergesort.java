package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/10/26
 */
public class Mergesort {
	public static void mergesort(int[] nums, int p, int r) {
		if (p >= r) return;
		int q = (p+r) >> 1;
		mergesort(nums, p, q);
		mergesort(nums, q+1, r);
		merge(nums, p, q, r);
	}
	
	private static void merge(int[] nums, int p, int q, int r) {
		int[] low = new int[q-p+1];
		int[] high = new int[r-q];
		int i;
		int j;
		int k = p;
		for (i = 0; k <= q; i++, k++) {
			low[i] = nums[k];
		}
		for (j = 0; k <= r; j++, k++) {
			high[j] = nums[k];
		}
		i=0;
		j=0;
		k=p;
		while (i<low.length && j<high.length) {
			if (low[i] < high[j]) {
				nums[k++] = low[i++];
			} else {
				nums[k++] = high[j++];
			}
		}
		while (i<low.length) {
			nums[k++] = low[i++];
		}
		while (j<high.length) {
			nums[k++] = high[j++];
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,7,3,4,6,5};
		mergesort(nums, 0, nums.length-1);
		for (int n : nums) {
			System.out.print(n);
		}
	}
}
