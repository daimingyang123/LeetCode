package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/7/1
 */
public class AllNodesDistanceKinBinaryTree {
	private List<Integer> res = new ArrayList<>();
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		LinkedHashSet<TreeNode> path = dfs(root, target, new LinkedHashSet<>());
		int size = path.size();
		for (TreeNode node : path) {
			int d = K - size + 1;
			size--;
			if (d < 0) continue;
			HashSet<TreeNode> set = new HashSet<>(path);
			set.remove(node);
			dfs(node, set, d);
		}
		return res;
	}
	
	private LinkedHashSet<TreeNode> dfs(TreeNode root, TreeNode target, LinkedHashSet<TreeNode> set) {
		if (root == null) return set;
		set.add(root);
		if (root == target) return set;
		LinkedHashSet<TreeNode> left = dfs(root.left, target, new LinkedHashSet<>(set));
		if (left.contains(target)) return left;
		return dfs(root.right, target, new LinkedHashSet<>(set));
	}
	
	private void dfs(TreeNode root, HashSet<TreeNode> set, int d) {
		if (root == null || set.contains(root)) return;
		if (d == 0) {
			res.add(root.val);
			return;
		}
		dfs(root.left, set, d-1);
		dfs(root.right, set, d-1);
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generate(new Integer[]{0,1,null,3,2});
		TreeNode target = root.left.right;
		int k = 1;
		List<Integer> res = new AllNodesDistanceKinBinaryTree().distanceK(root, target, k);
		System.out.println(res);
	}
}
