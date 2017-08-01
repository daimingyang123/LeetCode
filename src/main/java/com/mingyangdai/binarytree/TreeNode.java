package com.mingyangdai.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 17/3/6
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
	
	public static TreeNode generate(int[] nums) {
		TreeNode root = new TreeNode(nums[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		generate(queue, nums, 1);
		return root;
	}
	
	public static void generate(Queue<TreeNode> queue, int[] nums, int index) {
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if (index >= nums.length) return;
			node.left = new TreeNode(nums[index++]);
			queue.add(node.left);
			
			if (index >= nums.length) return;
			node.right = new TreeNode(nums[index++]);
			queue.add(node.right);
		}
	}
	
	public static void traverse(TreeNode root) {
		if (root == null) return;
		int depth = getDepth(root);
		int length = (int) Math.pow(2, depth - 1);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node;
		while (!queue.isEmpty()) {
			Queue<TreeNode> queue2 = new LinkedList<>();
			
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
	
	private static int getDepth(TreeNode root) {
		if (root == null) return 0;
		return 1 + getDepth(root.left);
	}
	
	private static void print(int mid, TreeNode node) {
		for (int i = 1; i < mid; i++) {
			System.out.print(" ");
		}
		System.out.print(node.val);
		
		for (int i = 1; i < mid; i++) {
			System.out.print(" ");
		}
		System.out.print(" ");
	}
	
	public static TreeNode find(TreeNode root, int val) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val == val) return node;
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = generate(nums);
		traverse(root);
	}
}
