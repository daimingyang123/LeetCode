package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/7/29
 */
public class PopulatingNextII {
	
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		if (root.left == null && root.right == null) return;
		
		TreeLinkNode left = root.left;
		TreeLinkNode right = root.right;
		TreeLinkNode next = root.next;
		
		if (left != null) left.next = right;
		
		while (next != null) {
			TreeLinkNode node = next.left == null ? next.right : next.left;
			if (right != null) right.next = node;
			
			connect(next);
			next = next.next;
		}
		
		if (left != null) connect(left);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		TreeLinkNode root = TreeLinkNode.generate(nums);
		root.right.left = null;
		
		PopulatingNextII nextII = new PopulatingNextII();
		nextII.connect(root);
		System.out.println("finished");
	}
}
