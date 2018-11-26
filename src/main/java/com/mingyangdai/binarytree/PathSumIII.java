package com.mingyangdai.binarytree;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/9/24
 */
public class PathSumIII {
	
	private List<Integer> result = Lists.newArrayList();
	
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		HashMap<TreeNode, Integer> map = new HashMap<>();
		map.put(root, root.val);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int val = map.get(node);
			if (node.left != null) {
				queue.offer(node.left);
				map.put(node.left, val + node.left.val);
			}
			if (node.right != null) {
				queue.offer(node.right);
				map.put(node.right, val + node.right.val);
			}
		}
		
		preorder(map, root, new ArrayList<>());
		
		int count = 0;
		for (int i : result) {
			if (i == sum) {
				count++;
			}
		}
		return count;
	}
	
	private void preorder(HashMap<TreeNode, Integer> map, TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.addAll(list);
			return;
		}
		int val = map.get(root);
		List<Integer> diff = new ArrayList<>();
		for (int i : list) {
			diff.add(val - i);
		}
		list.addAll(diff);
		preorder(map, root.left, new ArrayList<>(list));
		preorder(map, root.right, new ArrayList<>(list));
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generate(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
		int sum = 8;
		int res = new PathSumIII().pathSum(root, sum);
		System.out.println(res);
	}
}
