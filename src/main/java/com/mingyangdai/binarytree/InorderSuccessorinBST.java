package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/8
 */
public class InorderSuccessorinBST {
	
	private LinkedHashMap<TreeNode, Integer> treeMap = new LinkedHashMap<>();
	private LinkedHashMap<Integer, TreeNode> indexMap = new LinkedHashMap<>();
	private int index;
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		treeMap.clear();
		indexMap.clear();
		index = 0;
		
		if (root == null) return root;
		inorder(root);
		int index = treeMap.get(p);
		return indexMap.get(index+1);
	}
	
	private void inorder(TreeNode root) {
		if (root.left != null) inorder(root.left);
		treeMap.put(root, index);
		indexMap.put(index, root);
		index++;
		if (root.right != null) inorder(root.right);
	}
	
	public static void main(String[] args) {
//		int[] nums = {1,2,3,4,5,6,7};
//		TreeNode root = TreeNode.generate(nums);
//		InorderSuccessorinBST bst = new InorderSuccessorinBST();
//		TreeNode target = root.right.right;
//		TreeNode res = bst.inorderSuccessor(root, target);
//		System.out.println(res.val);
		System.out.println(Math.pow(2, 20));
		List<Integer> list = new ArrayList<>();
		List<Integer> a = new ArrayList<>(list);
	}
	
	
}
