package com.mingyangdai;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private boolean isPalindrome(char[] array) {
		int start = 0, end = array.length-1;
		while (start < end) {
			switch (array[start]) {
				case '6':
					if (array[end] != '9') return false;
				case '9':
					if (array[end] != '6') return false;
				default:
					if (array[start] != array[end]) return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i=0; i<k; i++) {
			sum += nums[i];
		}
		int max = sum;
		for (int i=k; i<nums.length; i++) {
			sum -= nums[i-k];
			sum += nums[i];
			max = Math.max(max, sum);
		}
		return max/k;
	}
	
	public static void main(String[] args) {
		AppTest test = new AppTest();
		String num = "60809";
		test.isPalindrome(num.toCharArray());
	}
}
