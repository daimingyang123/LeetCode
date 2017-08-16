package com.mingyangdai.binarytree;

import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2017/8/16
 */
public class LargestBSTSubtree {
	
	int count = 0;
	private HashMap<TreeNode, Integer> maxMap = new HashMap<>();
	private int max = 0;
	
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		isBST(root);
		return max;
	}
	
	private boolean isBST(TreeNode root) {
		TreeNode left = root.left;
		TreeNode right = root.right;
		int localCount = 1;
		int maxVal = root.val;
		
		if (left != null) {
			if ( isBST(left) && root.val > maxMap.get(left) ) {
				count += localCount;
			} else {
				return false;
			}
		}
		if (right != null){
			if ( isBST(right) && root.val < maxMap.get(right) ) {
				count += localCount;
				maxVal = maxMap.get(right);
			} else {
				return false;
			}
		}
		
		count = localCount;
		maxMap.put(root, maxVal);
		max = Math.max(max, count);
		return true;
	}
	
	public static void main(String[] args) {
	
	}
}
