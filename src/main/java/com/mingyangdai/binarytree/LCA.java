package com.mingyangdai.binarytree;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/7/28
 */
public class LCA {
	
	public static void main(String[] args) {
//		int[] nums = new int[10000];
//		for (int i=0; i<nums.length; i++) {
//			nums[i] = i;
//		}
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		TreeNode root = TreeNode.generate(nums);
//		TreeNode.traverse(root);
		
		LCA lca = new LCA();
		TreeNode p = TreeNode.find(root, 4);
		TreeNode q = TreeNode.find(root, 3);
		TreeNode res = lca.lowestCommonAncestor2(root, p, q);
		System.out.println(res.val);
	}
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor2(root.left, p, q);
		TreeNode right = lowestCommonAncestor2(root.right, p, q);
		if (left != null && right != null) return root;
		return left != null ? left : right;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		
		Stack<TreeNode> stack = new Stack<>();
		dfs(root, stack, p);
		HashSet<TreeNode> set = new HashSet<>();
		dfs(root, set, q);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (set.contains(node)) return node;
		}
		return null;
	}
	
	private boolean dfs(TreeNode root, Stack<TreeNode> stack, TreeNode target) {
		stack.push(root);
		if (root.equals(target)) return true;
		if (root.left == null && root.right == null) return false;
		
		if (root.left != null) {
			if (dfs(root.left, stack, target)) return true;
			else stack.pop();
		}
		if (root.right != null) {
			if (dfs(root.right, stack, target)) return true;
			else stack.pop();
		}
		return false;
	}
	
	private boolean dfs(TreeNode root, HashSet<TreeNode> set, TreeNode target) {
		set.add(root);
		if (root.equals(target)) return true;
		if (root.left == null && root.right == null) return false;
		
		if (root.left != null) {
			if (dfs(root.left, set, target)) return true;
			else set.remove(root.left);
		}
		if (root.right != null) {
			if (dfs(root.right, set, target)) return true;
			else set.remove(root.right);
		}
		return false;
	}
	
}
