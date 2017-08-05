package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/8/3
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head.next == null) return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode first = dummy.next;
		while (first != null && first.next != null) {
			ListNode second = first.next;
			ListNode next = second.next;
			second.next = first;
			first.next = next;
			
			if (pre != null) pre.next = second;
			pre = first;
			first = next;
		}
		
		return dummy.next;
	}
	
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode second = head.next;
		head.next = swapPairs2(head.next.next);
		second.next = head;
		return second;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		ListNode head = ListNode.generate(nums);
		SwapNodesinPairs pairs = new SwapNodesinPairs();
		ListNode newHead = pairs.swapPairs2(head);
		ListNode.traversalLinkedList(newHead);
	}
}
