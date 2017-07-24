package com.mingyangdai;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 16/4/2
 */

public class Add {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		
		ListNode head = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
		
		Add add = new Add();
		ListNode result = add.reverseB(head);
		ListNode.traversalLinkedList(result);
	}
	
	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		ListNode cur = head, fast = head, slow = head;
		int length = 0;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		k = k % length;
		if (k == 0) return head;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		ListNode temp = slow.next;
		slow.next = null;
		return temp;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode l1 = new ListNode(-1);
		l1.next = headA;
		while (l1.next != null) {
			l1 = l1.next;
			set.add(l1);
		}
		
		ListNode l2 = new ListNode(-1);
		l2.next = headB;
		while (l2.next != null) {
			l2 = l2.next;
			if (set.contains(l2)) return l2;
		}
		
		return null;
	}
	
	public ListNode reverseB(ListNode current) {
		if (current == null || current.next == null) return current;
		ListNode nextNode = current.next;
		current.next = null;
		ListNode reverseRest = reverseB(nextNode);
		nextNode.next = current;
		return reverseRest;
	}
	
}
