package com.mingyangdai;

import com.mingyangdai.LinkedList.ListNode;

import java.util.PriorityQueue;

/**
 * @author mingyang.dai
 * @since 17/4/1
 */
public class Cycle {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(1);
		queue.add(3);
		queue.add(0);
		queue.add(1);
		queue.peek();
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast.equals(slow)) {
				return true;
			}
		}
		return false;
	}
}
