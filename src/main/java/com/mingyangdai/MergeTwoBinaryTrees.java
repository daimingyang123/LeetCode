package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/7/7
 */
public class MergeTwoBinaryTrees {
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		MergeTwoBinaryTrees trees = new MergeTwoBinaryTrees();
		TreeNode result = trees.mergeTrees(t1, null);
		System.out.println(result);
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return null;
		
		TreeNode root;
		if (t1 == null) {
			root = t2;
			root.left = t2.left;
			root.right = t2.right;
		} else if (t2 == null) {
			root = t1;
			root.left = t1.left;
			root.right = t1.right;
		} else {
			root = new TreeNode(getVal(t1) + getVal(t2));
			root.left = mergeTrees(t1.left, t2.left);
			root.right = mergeTrees(t1.right, t2.right);
		}
		
		return root;
	}
	
	private int getVal(TreeNode node) {
		return node == null ? 0 : node.val;
	}
}
