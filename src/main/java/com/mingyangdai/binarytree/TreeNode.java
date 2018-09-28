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
	
	private static TreeNode real = null;
	
	public static TreeNode generate(Integer[] nums) {
		TreeNode root = new TreeNode(nums[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		generate(queue, nums, 1);
		return root;
	}
	
	public static void generate(Queue<TreeNode> queue, Integer[] nums, int index) {
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				index += 2;
				continue;
			}
			
			if (index >= nums.length) return;
			if (nums[index] != null) {
				node.left = new TreeNode(nums[index]);
			}
			queue.add(node.left);
			index++;
			
			if (index >= nums.length) return;
			if (nums[index] != null) {
				node.right = new TreeNode(nums[index]);
			}
			queue.add(node.right);
			index++;
		}
	}
	
	private static void processNull(TreeNode root) {
		if (root == null) return;
		if (root.left != null && root.left.val == -1) root.left = null;
		processNull(root.left);
		if (root.right != null && root.right.val == -1) root.right = null;
		processNull(root.right);
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
		Integer[] nums = {1,null, 2, null, null, null, 3};
		TreeNode root = generate(nums);
		traverse(root);
	}
}
