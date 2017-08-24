package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/7/14
 */
public class CopyRandomList {
	
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		l2.random = head;
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		l3.random = l4;
		
		head.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		CopyRandomList list = new CopyRandomList();
		RandomListNode newHead = list.copyRandomList(head);
		System.out.println(newHead);
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode node = new RandomListNode(head.label);
			RandomListNode temp = cur.next;
			cur.next = node;
			node.next = temp;
			
			if (cur.random != null) {
				RandomListNode random = new RandomListNode(cur.random.label);
				node.random = random;
			}
			cur = temp;
		}
		
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode newHead = dummy;
		while (head != null && head.next != null) {
			RandomListNode node = head.next;
			
			newHead.next = node;
			newHead = newHead.next;
			newHead.next = null;
			
			head = head.next.next;
		}
		
		return dummy.next;
	}
	
}
