package com.mingyangdai.binarytree;

import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2017/8/16
 */
public class LargestBSTSubtree {
	private HashMap<TreeNode, Integer> countMap = new HashMap<>();
	private HashMap<TreeNode, Integer> maxMap = new HashMap<>();
	
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		countMap.put(null, 0);
		if (isBST(root)) return countMap.get(root);
		if (isBST(root.left)) return countMap.get(root.left);
		
		if (root.left == null && root.right == null) return 1;
		if (root.left == null) return largest(root.right) + 1;
		if (root.right == null) return largest(root.left) + 1;
		return Math.max(largest(root.left), largest(root.right));
	}
	
	private boolean isBST(TreeNode root) {
		if (root == null) {
			countMap.put(null, 0);
			return true;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		Integer count = 1;
		Integer max = root.val;
		
		if ( isBST(left) && root.val > maxMap.get(left) ) {
			count += countMap.get(left);
		}
		if ( isBST(right) && root.val < maxMap.get(right) ) {
			count += countMap.get(right);
			max = maxMap.get(right);
		}
		countMap.put(root, count);
		maxMap.put(root, max);
		
		if (count == 1) return false;
		return true;
	}
	
	private int largest(TreeNode root) {
		if (root == null) return 0;
		return largest(root.left) + largest(root.right) + 1;
	}
	
	public static void main(String[] args) {
	
	}
}
