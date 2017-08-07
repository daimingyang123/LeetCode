package com.mingyangdai.binarytree;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/8/6
 */
public class Traversal {
	
	public void inorder(TreeNode node) {
		if (node == null) return;
		if (node.left != null) inorder(node.left);
		System.out.print(node.val);
		if (node.right != null) inorder(node.right);
	}
	
	public void test(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode node = stack.peek();
		node.left = null;
		stack.pop();
		switch (root.val) {
			case 1:
				break;
			case 2:
				break;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = TreeNode.generate(nums);
		Traversal traversal = new Traversal();
//		traversal.inorder(root);
		traversal.test(root);
	}
}
