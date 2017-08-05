package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/8/4
 */
public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				res.add(list);
				list = new ArrayList<Integer>();
				if (!queue.isEmpty()) queue.offer(null);
			} else {
				list.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		TreeNode root = TreeNode.generate(nums);
		BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> res = traversal.levelOrder(root);
		System.out.println(res);
	}
}
