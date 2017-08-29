package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/7/29
 */
public class PopulatingNextRightPointersinEachNode {
	
	public void connect(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode left  = root.left;
			while (root != null) {
				if (root.left != null) {
					root.left.next = root.right;
					if (root.next != null && root.right != null) {
						root.right.next = root.next.left;
					}
				}
				root = root.next;
			}
			root = left;
		}
	}
	
	public static void main(String[] args) {
//		int[] nums = new int[15];
//		for (int i = 1; i <= nums.length; i++) {
//			nums[i - 1] = i;
//		}
		int[] nums = {1,2,3,4,5,6,7};
		TreeLinkNode root = TreeLinkNode.generate(nums);
		PopulatingNextRightPointersinEachNode left = new PopulatingNextRightPointersinEachNode();
		left.connect(root);
		System.out.println(root);
	}
}
