package com.mingyangdai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 15/11/17
 */

public class CaffeineBuzz {
	
	public static void main(String[] args) {
		CaffeineBuzz caffeineBuzz = new CaffeineBuzz();
//        int[] nums = {1,2,3,4,5,6,7};
//        caffeineBuzz.rotate(nums, 3);
		int result = caffeineBuzz.hammingWeight(0);
		System.out.println(result);
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<List<String>>();
		partition(results, s, 0, new ArrayList<String>());
		return results;
	}
	
	public void partition(List<List<String>> results, String s, int start,
						  List<String> path) {
		
		if (start == s.length()) {
			results.add(new ArrayList<String>(path));
			return;
		}
		
		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (isPalindrome(sub)) {
				path.add(sub);
				partition(results, s, i, path);
				path.remove(path.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String word) {
		int start = 0, end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public String convertToTitle(int n) {
		StringBuilder builder = new StringBuilder();
		int tmp;
		while (n > 26) {
			tmp = n / 26 + 64;
			builder.append((char) tmp);
			n = n - 26;
		}
		builder.append((char) (n + 64));
		return builder.toString();
	}
	
	public int trailingZeroes(int n) {
		int result = 0;
		String s = Integer.toString(n);
		if (s.charAt(s.length() - 1) >= '5') {
			s = s.substring(0, s.length() - 1) + "5";
		} else {
			s = s.substring(0, s.length() - 1) + "0";
		}
		n = Integer.parseInt(s);
		
		while (n > 0) {
			result += getNumOfFive(n);
			n = n - 5;
		}
		return result;
	}
	
	private int getNumOfFive(int n) {
		int result = 0;
		while (n % 5 == 0) {
			result++;
			n = n / 5;
		}
		if (n % 5 == 0) result++;
		return result;
	}
	
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public int reverseBits(int n) {
		if (n == 0) return 0;
		
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			if ((n & 1) == 1) result++;
			n >>= 1;
		}
		return result;
	}
	
	public int hammingWeight(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) result++;
			n >>= 1;
		}
		return result;
	}
	
	public int countPrimes(int n) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < n; i++) {
			map.put(n, true);
		}
		
		int count = 0;
		for (int i = 1; i < n; i++) {
//            if (isPrime(i)) count++;
		}
		return count;
	}
}

