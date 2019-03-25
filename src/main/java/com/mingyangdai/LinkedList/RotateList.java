package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2018/11/17
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		k = len - k%len;
		
		node = head;
		while (k > 1) {
			k--;
			node = node.next;
		}
		ListNode next = node.next;
		node.next = null;
		next.next = node;
		
		return next;
	}
	
	public static void main(String args[]) {
		ListNode head = ListNode.generate(new int[]{1,2,3,4,5});
		ListNode node = new RotateList().rotateRight(head, 2);
		ListNode.traversalLinkedList(node);
	}
}
