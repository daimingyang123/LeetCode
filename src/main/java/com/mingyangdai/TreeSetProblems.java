package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mingyang.dai
 * @since 2017/6/21
 */
public class TreeSetProblems {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);

//		l1.next = l3;
		l2.next = l4;
		l6.next = l5;
		
		TreeSetProblems problems = new TreeSetProblems();
		ListNode[] lists = {};
		ListNode result = problems.mergeKLists(lists);
		
		ListNode.traversalLinkedList(result);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
		
		for (ListNode head : lists) {
			if (head != null) queue.add(head);
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			head.next = new ListNode(node.val);
			head = head.next;
			
			node = node.next;
			if (node == null) continue;
			queue.add(node);
		}
		
		return dummy.next;
	}
}
