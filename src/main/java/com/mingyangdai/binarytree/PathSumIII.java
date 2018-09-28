package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/9/24
 */
public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	private int pathSumFrom(TreeNode node, int sum) {
		if (node == null) return 0;
		return (node.val == sum ? 1 : 0)
				+ pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
	}
	
	public static void main(String[] args) {

	}
}
