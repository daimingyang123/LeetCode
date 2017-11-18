package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/11/14
 */
public class PartitionList {
	
	public static ListNode partition(ListNode head, int x) {
		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		while (head != null) {
			if (head.val < x) {
				smaller.next = head;
				smaller = smaller.next;
//				smaller = smaller.next = head;
			} else {
				bigger = bigger.next = head;
			}
			head = head.next;
		}
		// no need for extra check because of fake heads
		smaller.next = biggerHead.next; // join bigger after smaller
		bigger.next = null; // cut off anything after bigger
		return smallerHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.generate(new int[]{1,4,3,2,5,2});
		int x = 3;
		ListNode result = partition(head, x);
		ListNode.traversalLinkedList(result);
	}
}
