package com.mingyangdai;

import java.util.Arrays;

/**
 * @author mingyang.dai
 * @since 17/3/20
 */
public class Merge {
	
	public static void main(String[] args) {
		Merge merge = new Merge();
		int[] nums1 = {1, 9, 10, 0, 0, 0};
		int[] nums2 = {2, 7, 9};
		int m = 3;
		int n = 3;
		merge.merge(nums1, m, nums2, n);
		
		for (int i : nums1) {
			System.out.println(i);
		}
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < m && j < n) {
			nums1[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
		}
		
		int[] nums3 = Arrays.copyOf(nums1, m);
	}
}
