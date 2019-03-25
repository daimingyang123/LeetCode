package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

/**
 * @author mingyang.dai
 * @since 17/4/7
 */
public class Linked {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(1);
		ListNode l8 = new ListNode(1);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
//        l7.next = l8;
		
		Linked linked = new Linked();
		
		ListNode node = l2;
		linked.deleteNode(node);
		ListNode.traversalLinkedList(l1);
//        boolean result = linked.isPalindrome(l1);
//        System.out.println(result);
	}
	
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		
		ListNode first = head;
		ListNode mid = findMid(head);
		ListNode second = reverse(mid);
		while (second != null) {
			if (first.val != second.val) return false;
			first = first.next;
			second = second.next;
		}
		return true;
	}
	
	private ListNode findMid(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.next;
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
	
	public void deleteNode(ListNode node) {
		if (node == null) return;
		ListNode pre = null;
		while (node.next != null) {
			node.val = node.next.val;
			pre = node;
			node = node.next;
		}
		pre.next = null;
	}
	
}
