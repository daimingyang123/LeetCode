package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

/**
 * @author mingyang.dai
 * @since 2017/7/5
 */
public class Intersection {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l3.next = l4;
		Intersection intersection = new Intersection();
		ListNode result = intersection.getIntersectionNode(l1, l3);
		System.out.println(result);
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		ListNode first = headA;
		ListNode second = headB;
		while (first != second) {
			first = first == null ? headB : first.next;
			second = second == null ? headA : second.next;
		}
		
		return first;
	}
}
