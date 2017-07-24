package com.mingyangdai.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/7/22
 */
public class AddTwoNumbersII {
	
	public static void main(String[] args) {
		int[] n1 = {9, 2, 3, 5, 5};
		ListNode l1 = ListNode.generate(n1);
		int[] n2 = {2, 3, 4, 5};
		ListNode l2 = ListNode.generate(n2);
		
		AddTwoNumbersII add = new AddTwoNumbersII();
		ListNode res = add.addTwoNumbers(l1, l2);
		ListNode.traversalLinkedList(res);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int length1 = getLength(l1);
		int length2 = getLength(l2);
		int diff = Math.abs(length1 - length2);
		ListNode l, s;
		if (length1 > length2) {
			l = l1;
			s = l2;
		} else {
			l = l2;
			s = l1;
		}
		
		int index = 0;
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (index < diff) {
			ListNode next = new ListNode(l.val);
			head.next = next;
			head = head.next;
			l = l.next;
			index++;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		while (l != null) {
			int val = l.val + s.val;
			int carry = val / 10;
			if (carry > 0) list.add(index - 1);
			val = val % 10;
			ListNode next = new ListNode(val);
			head.next = next;
			
			head = head.next;
			l = l.next;
			s = s.next;
			index++;
		}
		
		ListNode oldHead = dummy.next;
		while (list.size() != 0) {
			head = oldHead;
			index = 0;
			
			if (list.get(0) == -1) {
				list.remove(0);
				ListNode newHead = new ListNode(1);
				dummy.next = newHead;
				newHead.next = head;
			}
			
			while (list.size() != 0 && head != null) {
				if (list.get(0) == index) {
					list.remove(0);
					int val = head.val + 1;
					int carry = val / 10;
					if (carry > 0) list.add(index - 1);
					head.val = val % 10;
				}
				head = head.next;
				index++;
			}
		}
		
		return dummy.next;
	}
	
	private int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
