package com.mingyangdai;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 17/3/20
 */
public class Symmetric {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(3);
		
		root.left = a;
		root.right = d;
		a.left = b;
		b.left = c;
		root.right = d;
//        a.left = c;
//        a.right = d;
//        b.left = e;
//        b.right = f;
		List<Integer> temp = new ArrayList<Integer>();
		Collections.reverse(temp);
		Symmetric symmetric = new Symmetric();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		TreeNode result = symmetric.sortedArrayToBST(nums);
		System.out.println(result);
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		if (root.left == null && root.right == null) return true;
		if (root.left != null && root.right != null && root.left.val == root.right.val) {
			return isSymmetric(root.left, root.right);
		}
		return false;
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left != null && right != null) {
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) &&
					compare(left.left, right.right) && compare(left.right, right.left);
		}
		return false;
	}
	
	private boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		return left != null && right != null && left.val == right.val;
	}

//            1
//            / \
//            2   2
//            / \ / \
//            3  4 4  3
	
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode node;
		
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
			
			while (!queue.isEmpty()) {
				node = queue.poll();
				list.add(node.val);
				if (node.left != null) queue2.add(node.left);
				if (node.right != null) queue2.add(node.right);
			}
			
			result.add(list);
			queue = queue2;
		}
		
		Collections.reverse(result);
		return result;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) return null;
		int mid = getMid(0, nums.length);
		HashSet<Integer> set = new HashSet<Integer>();
		TreeNode root = new TreeNode(nums[mid]);
		set.add(nums[mid]);
		sortedArrayToBST(root, nums, 0, nums.length, set);
		return root;
	}
	
	private void sortedArrayToBST(TreeNode root, int[] nums, int start, int end, HashSet<Integer> set) {
		int mid = getMid(start, end), left, right;
		left = getMid(start, mid);
		if (set.contains(nums[left])) return;
		root.left = new TreeNode(nums[left]);
		set.add(nums[left]);
		
		right = getMid(mid, end);
		if (set.contains(nums[right])) return;
		root.right = new TreeNode(nums[right]);
		set.add(nums[right]);
		
		sortedArrayToBST(root.left, nums, 0, mid, set);
		sortedArrayToBST(root.right, nums, mid, end, set);
	}
	
	private int getMid(int start, int end) {
		return (start + end) / 2;
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		try {
			return null != getDepth(root);
		} catch (Exception e) {
			return false;
		}
	}
	
	private Integer getDepth(TreeNode root) {
		if (root == null) return 0;
		Integer left = getDepth(root.left);
		Integer right = getDepth(root.right);
		if (Math.abs(left - right) <= 1) return 1 + Math.max(left, right);
		return null;
	}
}
