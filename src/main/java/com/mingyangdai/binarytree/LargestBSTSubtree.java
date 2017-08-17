package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/16
 */
public class LargestBSTSubtree {
	private TreeNode root;
	private int index;
	
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		this.root = root;
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		
		int left = 0;
		for (int i = 0; i < index; i++) {
			if (list.get(i+1) > list.get(i)) left++;
			else break;
		}
		
		int right = 0;
		for (int i = index+1; i < list.size(); i++) {
			if (list.get(i) > list.get(i-1)) right++;
			else break;
		}
		
		if (left + right == list.size()-1) return list.size();
		return Math.max(left, right);
	}
	
	private void inorder(TreeNode root, List<Integer> list) {
		if (root.left != null) inorder(root.left, list);
		list.add(root.val);
		if (root == this.root) index = list.size()-1;
		if (root.right != null) inorder(root.right, list);
	}
	
	public static void main(String[] args) {
		int[] nums = {10,5,15,1,8,1,16};
		TreeNode root = TreeNode.generate(nums);
		LargestBSTSubtree largestBSTSubtree = new LargestBSTSubtree();
		int res = largestBSTSubtree.largestBSTSubtree(root);
		System.out.println(res);
	}
}
