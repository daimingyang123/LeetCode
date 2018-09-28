package com.mingyangdai.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author mingyang.dai
 * @since 2018/7/8
 */
public class SmallestSubtreewithalltheDeepestNodes {
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		HashMap<TreeNode, TreeNode> map = new HashMap<>();
		HashSet<TreeNode> set = new HashSet<>();
		dfs(root, map, set);
		
		while (set.size() != 1) {
			HashSet<TreeNode> set2 = new HashSet<>();
			Iterator<TreeNode> iterator = set.iterator();
			while (iterator.hasNext()) {
				TreeNode node = iterator.next();
				set2.add(map.get(node));
			}
			set = set2;
		}
		return set.iterator().next();
	}
	
	private void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map, HashSet<TreeNode> set) {
		if (root.left == null && root.right == null) {
			set.add(root);
			return;
		}
		if (root.left != null) {
			map.put(root.left, root);
			dfs(root.left, map, set);
		}
		if (root.right != null) {
			map.put(root.right, root);
			dfs(root.right, map, set);
		}
	}
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TreeNode.generate(nums);
		TreeNode res = new SmallestSubtreewithalltheDeepestNodes().subtreeWithAllDeepest(root);
		TreeNode.traverse(res);
	}
}
