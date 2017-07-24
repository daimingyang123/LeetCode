package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 16/12/23
 */
public class Mid {
	
	public static int kthSmall(int[] arr1, int[] arr2, int k) {
		List<Integer> mergeResult = new ArrayList<Integer>();
		int index1 = 0, index2 = 0;
		while (index1 < arr1.length && index2 < arr2.length) {
			if (arr1[index1] < arr2[index2]) {
				mergeResult.add(arr1[index1++]);
			} else {
				mergeResult.add(arr2[index2++]);
			}
		}
		while (index1 < arr1.length) {
			mergeResult.add(arr1[index1++]);
		}
		while (index2 < arr1.length) {
			mergeResult.add(arr2[index2++]);
		}
		return mergeResult.get(k - 1);
	}
	
	public static List<List<Integer>> combinations(int[] nums, int k) {
		int index = 0;
		List<Integer> cur = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(nums, k, index, cur, result);
		return result;
	}
	
	private static void combine(int[] nums, int k, int index, List<Integer> cur, List<List<Integer>> result) {
		if (cur.size() == k) {
			result.add(new ArrayList<Integer>(cur));
		} else {
			for (int i = index; i < nums.length; i++) {
				cur.add(nums[i]);
				combine(nums, k, ++index, cur, result);
				cur.remove(cur.size() - 1);
				while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
			}
		}
	}
	
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head, slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		//快慢双指针找到中点
		while (fast.next != null && fast.next.next != null) {
			stack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		//中点
		if (slow.val == slow.next.val) {
			stack.push(slow.val);
		}
		//中点之后的元素和中点之前的元素逐个对比
		while (slow.next != null) {
			slow = slow.next;
			if (slow.val != stack.pop()) {
				return false;
			}
		}
		return true;
	}
	
	public static String transform(int n) {
		int index = 65;
		List<String> cur = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		return get(n, index, cur, result);
	}
	
	private static String get(int n, int index, List<String> cur, List<String> result) {
		while (result.size() < n) {
			for (int i = index; i < 90; i++) {
				cur.add(String.valueOf((char) i));
				result.add(String.join("", cur));
				get(n, ++index, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
		return result.get(result.size() - 1);
		
	}
	
	public static void main(String[] args) {
		Mid solution = new Mid();
//        int arr1[] = new int[]{1,3,5};
//        int arr2[] = new int[]{2,4,6};
//        System.out.println(solution.kthSmall(arr1, arr2, 5));
//        int nums[] = new int[]{2,3,3};
//        System.out.println(solution.combinations(nums, 2));
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
		System.out.println(isPalindrome(node1));
//        System.out.println(solution.transform(3));
	}
}
