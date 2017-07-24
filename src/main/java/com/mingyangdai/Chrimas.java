package com.mingyangdai;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 17/4/2
 */
public class Chrimas {
	
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		Chrimas chrimas = new Chrimas();
		chrimas.printChristmasTree(one);
	}
	
	public void printChristmasTree(Node Root) {
		if (Root == null) return;
		int depth = getDepth(Root);
		int length = (int) Math.pow(2, depth - 1);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(Root);
		Node node;
		while (!queue.isEmpty()) {
			Queue<Node> queue2 = new LinkedList<Node>();
			
			while (!queue.isEmpty()) {
				node = queue.poll();
				print(length, node);
				if (node.left != null) queue2.add(node.left);
				if (node.right != null) queue2.add(node.right);
			}
			System.out.println();
			queue = queue2;
			length = length / 2;
		}
		
	}
	
	private int getDepth(Node root) {
		if (root == null) return 0;
		return 1 + getDepth(root.left);
	}
	
	private void print(int mid, Node node) {
		for (int i = 1; i < mid; i++) {
			System.out.print(" ");
		}
		System.out.print(node.val);
		
		for (int i = 1; i < mid; i++) {
			System.out.print(" ");
		}
		System.out.print(" ");
	}
}
