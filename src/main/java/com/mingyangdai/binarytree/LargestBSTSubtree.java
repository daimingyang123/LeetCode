package com.mingyangdai.binarytree;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/8/16
 */
public class LargestBSTSubtree {
	int max = 0;
	
	public int largestBSTSubtree(TreeNode root) {
		inorder(root, new Stack<>());
		return max;
	}
	
	private int inorder(TreeNode root, Stack<Integer> stack) {
		if (root == null) return 0;
		boolean valid = true;
		
		int left = inorder(root.left, stack);
		if (!stack.isEmpty() && root.val < stack.pop()) valid = false;
		stack.push(root.val);
		int right = inorder(root.right, stack);
		
		int res;
		if (!valid) res = 0;
		else if (root.left != null && left == 0) res = 0;
		else if (root.right != null && right == 0) res = 0;
		else res = left + right + 1;
		max = Math.max(max, res);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
//		int[] nums = {3,2,-1,-1,4,-1,-1,1};
//		TreeNode root = TreeNode.generate(nums);
//		root.right = null;
//		root.left.left = null;
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(1);
		LargestBSTSubtree largestBSTSubtree = new LargestBSTSubtree();
		int res = largestBSTSubtree.largestBSTSubtree(root);
		System.out.println(res);
	}
}
