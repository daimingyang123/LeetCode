package com.mingyangdai.Binary;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/7/28
 */
public class LCA {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		
		Stack<TreeNode> stack = new Stack<>();
		dfs(root, stack, p);
		HashSet<TreeNode> set = new HashSet<>();
		dfs(root, set, q);
		
		while (stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(set.contains(node)) return node;
		}
		
		return null;
	}
	
	private Stack<TreeNode> dfs(TreeNode root, Stack<TreeNode> stack, TreeNode target) {
		stack.push(root);
		if(root.equals(target)) return stack;
		if(root.left == null && root.right == null) stack.clear();
		
		if(root.left != null) dfs(root.left, stack, target);
		if(root.right != null) dfs(root.right, stack, target);
		return null;
	}
	
	private Set<TreeNode> dfs(TreeNode root, HashSet<TreeNode> set, TreeNode target) {
		set.add(root);
		if(root.equals(target)) return set;
		if(root.left == null && root.right == null) set.clear();
		
		if(root.left != null) dfs(root.left, set, target);
		if(root.right != null) dfs(root.right, set, target);
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		TreeNode root = TreeNode.generate(nums);
		TreeNode.traverse(root);
		
		LCA lca = new LCA();
		TreeNode p = TreeNode.find(root, 4);
		TreeNode q = TreeNode.find(root, 5);
		TreeNode res = lca.lowestCommonAncestor(root, p, q);
		System.out.println(res);
	}
	
}
