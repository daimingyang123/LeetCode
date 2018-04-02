package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2018/3/19
 */
public class LongestUnivaluePath {
	int max = 0;
	
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return max;
		path(root, root.val);
		longestUnivaluePath(root.left);
		longestUnivaluePath(root.right);
		return max;
	}
	
	private int path(TreeNode root, int val) {
		if (root == null || root.val != val) return 0;
		int res = (root.val == val ? 1 : 0) + path(root.left, val) + path(root.right, val);
		max = Math.max(max, res-1);
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generate(new int[]{5, 4, 5, 1, 1, 5});
		int res = new LongestUnivaluePath().longestUnivaluePath(root);
		System.out.println(res);
	}
}
