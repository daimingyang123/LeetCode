package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/12/13
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		pathSum(root, new ArrayList<Integer>(), sum, res);
		return res;
	}
	
	private void pathSum(TreeNode root, List<Integer> cur, int sum, List<List<Integer>> res) {
		if (root == null) return;
		cur.add(root.val);
		sum -= root.val;
		if (root.left == null && root.right == null && sum == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		
		pathSum(root.left, new ArrayList<Integer>(cur), sum, res);
		pathSum(root.right, new ArrayList<Integer>(cur), sum, res);
	}
}
