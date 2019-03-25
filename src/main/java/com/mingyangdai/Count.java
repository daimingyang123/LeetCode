package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

/**
 * @author mingyang.dai
 * @since 17/3/17
 */
public class Count {
	
	public static void main(String[] args) {
		Count count = new Count();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(2);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		ListNode result = count.deleteDuplicates(a);
		System.out.println(result);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		
		return dummy.next;
	}
}
