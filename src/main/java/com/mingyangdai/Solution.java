package com.mingyangdai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] strings = {"15", "3", "11"};
		Arrays.sort(strings);
		for (String s : strings) {
			System.out.println(s);
		}
//        int[] nums = {1,2};
//        int result = solution.maxSubArray(nums);
//        System.out.println(result);
	}
	
	public List<Integer> PrintPath(Node Root, int key) {
		List<Integer> cur = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		findPath(Root, key, cur, result);
		return result;
	}
	
	private void findPath(Node root, int key, List<Integer> cur, List<Integer> result) {
		if (root == null) return;
		
		cur.add(root.val);
		if (root.val == key) {
			result.addAll(cur);
			return;
		}
		
		findPath(root.leftChild, key, new ArrayList<Integer>(cur), result);
		findPath(root.rightChild, key, new ArrayList<Integer>(cur), result);
	}
	
	
	/**
	 * 从string头部开始 如果以长度为1分割出来的所有subString 都在1~26之间 result++
	 * 尝试将第一个subString的长度为2 继续看分割出来的subString是否有效 如果都有效 result++
	 * 尝试将第二个subString的长度为2
	 * 以此类推
	 * (1~26之间为有效 所以尝试长度1或者2就可以了)
	 *
	 * @param number
	 * @return
	 */
	public int stringCombinationNum(String number) {
		int result = 0;
		
		//长度为1
		if (isValid(number.substring(0, 1)) && isValidTail(number.substring(1))) {
			result++;
		}
		
		//长度为2
		for (int i = 0; i + 2 < number.length(); i++) {
			if (isValid(number.substring(i, i + 2)) && isValidTail(number.substring(i + 2))) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	 * 长度为1分割剩余字符串 是否有效
	 *
	 * @param number
	 * @return
	 */
	private boolean isValidTail(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!isValid(number.substring(i, i + 1))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 分割出来的string是否有效
	 *
	 * @param num
	 * @return
	 */
	private boolean isValid(String num) {
		int val = Integer.parseInt(num);
		return val >= 1 && val <= 26;
	}
	
	
	/**
	 * 没看懂题
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String divide(int num1, int num2) {
		if (num1 == 0) return "0";
		StringBuilder stringBuilder = new StringBuilder();
		if (num1 / num2 == 0) {
			stringBuilder.append("0");
			stringBuilder.append(num2);
			return stringBuilder.toString();
		}
		return Integer.toString(num1 / num2);
	}
	
	
	/**
	 * word本身不是回文 从从头部开始尝试插入word中包含的字符
	 *
	 * @param word
	 * @return
	 */
	public int minimumPalindrome(String word) {
		if (isPalindrome(word)) return 0;
		return 1;
	}


//    public int findMaxConsecutiveOnes(int[] nums) {
//        int temp = 0,max = 0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] == 1){
//                temp++;
//            }else{
//                max = Math.max(max,temp);
//                temp = 0;
//            }
//        }
//        return Math.max(max,temp);
//    }
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int res = 0, l = 0, flip = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				--flip;
			}
			if (flip >= 0) {
				res = Math.max(res, i - l + 1);
			} else {
				while (l < nums.length && flip != 0) {
					if (nums[l] == 0) {
						++flip;
					}
					++l;
				}
			}
		}
		return res;
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
	
	static class Node {
		int val;
		Node leftChild;
		Node rightChild;
		
		public Node(int val) {
			this.val = val;
		}
	}
}