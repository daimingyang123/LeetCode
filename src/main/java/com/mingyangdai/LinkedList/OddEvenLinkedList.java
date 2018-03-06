package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2018/3/2
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return head;
		ListNode oddHead = new ListNode(-1);
		ListNode evenHead = new ListNode(-1);
		
		ListNode odd = oddHead;
		ListNode even = evenHead;
		while (head != null) {
			odd.next = head;
			odd = odd.next;
			if (head.next == null) {
				break;
			}
			
			even.next = head.next;
			even = even.next;
			head = head.next.next;
		}
		
		odd.next = evenHead.next;
		return oddHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.generate(new int[]{1,2,3});
		ListNode res = new OddEvenLinkedList().oddEvenList(head);
		ListNode.traversalLinkedList(res);
	}
}
