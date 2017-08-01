package com.mingyangdai.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/7/29
 */
public class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	
	TreeLinkNode(int x) {
		val = x;
	}
	
	public static TreeLinkNode generate(int[] nums) {
		TreeLinkNode root = new TreeLinkNode(nums[0]);
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		
		generate(queue, nums, 1);
		return root;
	}
	
	public static void generate(Queue<TreeLinkNode> queue, int[] nums, int index) {
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			
			if (index >= nums.length) return;
			node.left = new TreeLinkNode(nums[index++]);
			queue.add(node.left);
			
			if (index >= nums.length) return;
			node.right = new TreeLinkNode(nums[index++]);
			queue.add(node.right);
		}
	}
}
