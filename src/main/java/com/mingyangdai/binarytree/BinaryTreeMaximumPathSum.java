package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/10/25
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		pathSum(root);
		return max;
	}
	
	private int pathSum(TreeNode root) {
		if (root == null) return 0;
		
		int sum = root.val;
		max = Math.max(max, sum);
		
		int left = maxPathSum(root.left);
		if (left > 0) sum += left;
		int right = maxPathSum(root.right);
		if (right > 0) sum+= right;
		
		max = Math.max(max, sum);
		return sum;
	}
	
	public static void main(String[] args) {
	}
}
