package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2018/11/22
 */
public class DeleteNodeinaLinkedList {
	
	public void deleteNode(ListNode node) {
		while (node.next != null) {
			node.val = node.next.val;
			node = node.next;
		}
		node = null;
	}
	
	public static void main(String args[]) {
		ListNode head = ListNode.generate(new int[]{4,5,1,9});
		ListNode node = head.next;
		new DeleteNodeinaLinkedList().deleteNode(node);
		ListNode.traversalLinkedList(head);
	}
}
