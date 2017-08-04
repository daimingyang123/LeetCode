package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/8/3
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head.next == null) return head;
		
		ListNode first = head;
		while (first != null && first.next != null) {
			ListNode second = first.next;
			ListNode next = second.next;
			
			second.next = first;
			first.next = next;
			first = next;
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		ListNode head = ListNode.generate(nums);
		SwapNodesinPairs pairs = new SwapNodesinPairs();
		ListNode newHead = pairs.swapPairs(head);
		ListNode.traversalLinkedList(newHead);
	}
}
