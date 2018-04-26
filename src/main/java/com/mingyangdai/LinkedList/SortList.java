package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2018/4/25
 */
public class SortList {
	
	public ListNode sortList(ListNode head) {
		ListNode sHead = head.next;
		head.next = null;
		ListNode sEnd;
		int base = 1, len = base - 1;
		while (sHead != null) {
			sEnd = sHead;
			for (int i = 0; i < len && sEnd != null; i++) {
				sEnd = sEnd.next;
			}
			ListNode tmp = sEnd.next;
			sEnd.next = null;
			
            head = merge(head, sHead);
			sHead = tmp;
			base <<= 1;
			len  = base - 1;
		}
		return head;
	}
	
	private ListNode merge(ListNode f, ListNode s) {
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (f != null && s != null) {
			if (f.val < s.val) {
				head.next = f;
				f = f.next;
			} else {
				head.next = s;
				s = s.next;
			}
			head = head.next;
		}
		while (f != null) {
			head.next = f;
			f = f.next;
		}
		while (s != null) {
			head.next = s;
			s = s.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.generate(new int[]{8,6,7,2,1,3,4,5});
		ListNode res = new SortList().sortList(head);
		ListNode.traversalLinkedList(res);
	}
}
