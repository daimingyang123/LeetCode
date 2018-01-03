package com.mingyangdai.array;

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
	
//	private int partition(int[] arr, int left, int right) {
//		int q = left;
//		for (int j=left; j<=right-1;j++){
//			if (arr[j] <= arr[right]){
//				swap(arr, j, q);
//				q++;
//			}
//		}
//		swap(arr, right, q);
//		return q;
//	}
	
//	private void swap(int[] nums, int first, int second){
//		int temp = nums[first];
//		nums[first] = nums[second];
//		nums[second] = temp;
//	}
	
	public int findKthLargest(int[] nums, int k) {
		if (nums.length == 1) return nums[0];
		
		int start = 0, end = nums.length-1;
		while (true) {
			int i = partition(nums, start, end);
			if (nums.length-i == k) return nums[i];
			if (nums.length-i > k) {
				start = k+1;
			} else {
				end = k-1;
			}
		}
	}
	
	public int partition(int[] nums, int left, int right) {
		int small = left, big=left;
		while (big < right) {
			if (nums[big] < nums[right]) {
				swap(nums, big, small++);
			}
			big++;
		}
		swap(nums, small, right);
		return small;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		KthLargestElementinanArray array =  new KthLargestElementinanArray();
		int[] nums = {2,1};
		int res = array.findKthLargest(nums,1);
		System.out.println(res);
	}
}
