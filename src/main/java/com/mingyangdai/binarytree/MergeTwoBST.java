package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/10/28
 */
public class MergeTwoBST {
	
	public static TreeNode mergeBST(TreeNode t1, TreeNode t2) {
		List<Integer> l1 = new ArrayList<>();
		inorder(t1, l1);
		List<Integer> l2 = new ArrayList<>();
		inorder(t2, l2);
		List<Integer> res = merge(l1, l2);
		return buildTree(res, 0, res.size()-1);
	}
	
	private static void inorder(TreeNode root, List<Integer> res) {
		if (root == null) return;
		inorder(root.left, res);
		res.add(root.val);
		inorder(root.right, res);
	}
	
	private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		List<Integer> res = new ArrayList<>();
		while (l1.size() > 0 && l2.size() > 0) {
			if (l1.get(0) < l2.get(0)) {
				res.add(l1.remove(0));
			} else {
				res.add(l2.remove(0));
			}
		}
		for (int n : l1) {
			res.add(n);
		}
		for (int n : l2) {
			res.add(n);
		}
		return res;
	}
	
	private static TreeNode buildTree(List<Integer> res, int s, int e) {
		if (s > e) return null;
		int i = (s+e) >> 1;
		TreeNode root = new TreeNode(res.get(i));
		root.left = buildTree(res, s, i-1);
		root.right = buildTree(res, i+1, e);
		return root;
	}
	
	public static void main(String[] args) {
	}
}
