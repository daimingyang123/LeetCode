package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 17/4/6
 */
public class BinaryTree {
	
	private int max;
	private List<Integer> depths = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		
		l1.left = l2;
		
		l2.left = l3;
		l2.right = l4;
		
		l3.left = l5;
		l4.right = l6;
		
		BinaryTree tree = new BinaryTree();
		int result = tree.diameterOfBinaryTree(l1);
		System.out.println(result);
	}
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	
	private void findNode(TreeNode root, TreeNode node, Map<TreeNode, TreeNode> map) {
		if (root.val == node.val) return;
		if (root.val > node.val) {
			map.put(root.left, root);
			findNode(root.left, node, map);
		} else {
			map.put(root.right, root);
			findNode(root.right, node, map);
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		getDepth(root);
		return max;
	}
	
	private int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		int path = left + right;
		max = Math.max(max, path);
		return Math.max(left, right) + 1;
	}
}
