package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 16/10/3
 */
public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	public static void traversalLinkedList(ListNode head) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(head.val);
		while (head.next != null) {
			head = head.next;
			stringBuilder.append(" -> ");
			stringBuilder.append(head.val);
		}
		System.out.println(stringBuilder.toString());
	}
	
	public static ListNode generate(int[] nums) {
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		for (int n : nums) {
			head.next = new ListNode(n);
			head = head.next;
		}
		return dummy.next;
	}
}
