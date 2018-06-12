package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/9/24
 */
public class PathSumIII {
	private int count = 0;
	
	public int pathSum(TreeNode root, int sum) {
		pathSumFrom(root, 0, sum);
		return count;
	}
	
	private void pathSumFrom(TreeNode root, int cur, int sum) {
		if (root == null) return;
		cur += root.val;
		if (cur == sum) count++;
		pathSumFrom(root.left, cur, sum);
		pathSumFrom(root.right, cur, sum);
		pathSumFrom(root.left, 0, sum);
		pathSumFrom(root.right, 0, sum);
	}
	
	public static void main(String[] args) {
		PathSumIII pathSumIII = new PathSumIII();
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		int sum = 3;
		
		int res = pathSumIII.pathSum(root, sum);
		System.out.println(res);
	}
}
