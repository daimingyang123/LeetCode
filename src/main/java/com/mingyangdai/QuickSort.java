package com.mingyangdai;

/**
 * Created by daimingyang on 15/8/5.
 */


public class QuickSort {
	public static void main(String[] args) {
		int array[] = {1, 3, 5, 2, 6, 2, 6, 8, 8, 3, 2, 3, 5, 4, 1};
		quicksort(array, 0, array.length - 1);
		
		for (int n : array) {
			System.out.println(n);
		}
	}
	
	public static void quicksort(int[] nums, int begin, int end) {
		if (begin >= end) {
			return; }
		int pivotPostion = partition(nums, begin, end);
		quicksort(nums, begin, pivotPostion - 1);
		quicksort(nums, pivotPostion + 1, end);
	}
	
	public static int partition(int[] nums, int begin, int end) {
		int pivot = nums[begin];
		while (begin < end) {
			while (begin < end && nums[end] >= pivot) {
				end--;
			}
			nums[begin] = nums[end];
			while (begin < end && nums[begin] <= pivot) {
				begin++; }
			nums[end] = nums[begin];
		}
		nums[begin] = pivot;
		return begin;
	}
}



