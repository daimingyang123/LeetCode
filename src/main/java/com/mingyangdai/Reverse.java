package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

/**
 * @author mingyang.dai
 * @since 2017/7/13
 */
public class Reverse {
	
	ListNode newHead = null;
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		Reverse reverse = new Reverse();
		ListNode res = reverse.reverseList(l1);
		ListNode.traversalLinkedList(res);
	}
	
	public ListNode reverseList(ListNode head) {
		reverse(head);
		return newHead;
	}
	
	private ListNode reverse(ListNode head) {
		if (head.next == null) {
			newHead = head;
			return newHead;
		}
		
		ListNode cur = reverse(head.next);
		cur.next = head;
		head.next = null;
		return head;
	}
}
