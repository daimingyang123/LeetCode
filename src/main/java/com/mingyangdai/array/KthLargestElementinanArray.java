package com.mingyangdai.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingyang.dai
 * @since 2017/8/5
 */
public class KthLargestElementinanArray {
	
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for (int n : nums) {
			queue.add(n);
//			if(queue.size() > k) queue.poll();
		}
		return queue.poll();
	}
	
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
	
	private int partition(int[] arr, int left, int right) {
		int q = left;
		for (int j=left; j<=right-1;j++){
			if (arr[j] <= arr[right]){
				swap(arr, j, q);
				q++;
			}
		}
		swap(arr, right, q);
		return q;
	}
	
	private void swap(int[] nums, int first, int second){
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
	
	public static void main(String[] args) {
		KthLargestElementinanArray array =  new KthLargestElementinanArray();
		int[] nums = {3,2,1,5,0,4};
		array.getLeastNumbers(nums,1);
	}
}
