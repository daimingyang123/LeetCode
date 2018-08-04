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
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			Queue<TreeNode> queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {
				root = queue.poll();
				list.add(root.val);
				if (root.left != null) {
					queue2.offer(root.left);
				}
				if (root.right != null) {
					queue2.offer(root.right);
				}
			}
			res.add(list);
			queue = queue2;
		}
		return res;
	}
	
	public static void main(String[] args) {
	}
}
