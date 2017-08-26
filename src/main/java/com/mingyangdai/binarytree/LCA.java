package com.mingyangdai.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/7/28
 */
public class LCA {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Queue<TreeNode> queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				TreeNode left = node.left;
				TreeNode right = node.right;
				
				TreeNode source = null;
				TreeNode target = null;
				if (left == p || right == p) {
					source = p;
					target = q;
				}
				if (left == q || right == q) {
					source = q;
					target = p;
				}
				if (source != null) {
					if (isChild(source, target)) return source;
					return node;
				}
				if (node.left != null) queue2.offer(node.left);
				if (node.right != null) queue2.offer(node.right);
			}
			queue = queue2;
		}
		return null;
	}
	
	private boolean isChild(TreeNode source, TreeNode target) {
		if (source == null) return false;
		if (source == target) return true;
		if (source.val < target.val) {
			return isChild(source.right, target);
		}
		return isChild(source.left, target);
	}
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q) return root;
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		if (root.val < min) return lowestCommonAncestor2(root.right, p, q);
		if (root.val > min && root.val < max) return root;
		return lowestCommonAncestor2(root.left, p, q);
	}
	
	public static void main(String[] args) {
		LCA lca = new LCA();
		int[] nums = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = TreeNode.generate(nums);
		TreeNode p = TreeNode.find(root, 3);
		TreeNode q = TreeNode.find(root, 9);
		TreeNode res = lca.lowestCommonAncestor2(root, p, q);
		System.out.println(res.val);
	}
}
