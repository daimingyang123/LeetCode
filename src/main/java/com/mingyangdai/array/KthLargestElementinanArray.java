package com.mingyangdai.array;

import java.util.Arrays;

/**
 * @author mingyang.dai
 * @since 2017/8/5
 */
public class KthLargestElementinanArray {
	
	public int[] getLeastNumbers(int[] input,int k){
		if(input.length == 0 || k<= 0) return null;
		int[] output = new int[k];
		int start = 0;
		int end = input.length-1;
		int index = partition(input,start,end);
		while(index != k-1){
			if(index > k-1){
				end = index -1;
				index = partition(input,start ,end);
			}
			else{
				start = index+1;
				index = partition(input,start ,end);
			}
		}
		for(int i = 0;i<k;i++){
			output[i] = input[i];
		}
		return output;
	}
	
	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k;
		int low = 0, high = nums.length-1;
		while (low < high) {
			int index = partition(nums, low, high);
			if (index == k) break;
			else if (index < k) {
				low = index + 1;
			} else {
				high = index - 1;
			}
		}
		return nums[k];
	}
	
	private int partition(int[] nums, int p, int r) {
		int q = p, j = p;
		while (j < r) {
			if (nums[j] < nums[r]) {
				swap(nums, j, q++);
			}
			j++;
		}
		swap(nums, r, q);
		return q;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	

	
	public static void main(String[] args) {
		KthLargestElementinanArray array =  new KthLargestElementinanArray();
		int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
		int res = array.findKthLargest(nums,20);
		System.out.println(res);
		Arrays.sort(nums);
		for (int i : nums) {
			System.out.print(i);
			System.out.print(",");
		}
	}
}
