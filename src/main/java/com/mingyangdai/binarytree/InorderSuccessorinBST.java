package com.mingyangdai.binarytree;

import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/8/8
 */
public class InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return null;
	}
	
	private void inorder(TreeNode root, Map<TreeNode, Integer> treeMap, int index, Map<Integer, TreeNode> indexMap, int target) {
		if (index == target) return;
		if (root.left != null) return;
		treeMap.put(root, index);
		indexMap.put(index, root);
	}
}
