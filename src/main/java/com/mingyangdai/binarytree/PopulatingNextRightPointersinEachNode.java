package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/7/29
 */
public class PopulatingNextRightPointersinEachNode {
	
	public static void main(String[] args) {
		int[] nums = new int[15];
		for (int i = 1; i <= nums.length; i++) {
			nums[i - 1] = i;
		}
		TreeLinkNode root = TreeLinkNode.generate(nums);
		PopulatingNextRightPointersinEachNode node = new PopulatingNextRightPointersinEachNode();
		node.connect(root);
		System.out.println(root);
	}
	
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		if (root.left != null) connect(root.left, root.right);
	}
	
	private void connect(TreeLinkNode left, TreeLinkNode right) {
		left.next = right;
		if (left.left != null) {
			connect(left.left, left.right);
		}
		if (right != null) {
			connect(right.left, right.right);
			if (left.right != null) {
				left.right.next = right.left;
			}
		}
	}
}
