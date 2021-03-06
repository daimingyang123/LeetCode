package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/7/29
 */
public class PopulatingNextII {
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while (cur != null) {
			if (cur.left != null) cur.left.next = cur.right;
			
			TreeLinkNode first = cur.right == null ? cur.left : cur.right;
			TreeLinkNode next = cur.next;
			if (first != null && next != null) {
				while (next != null && next.left == null && next.right == null) {
					next = next.next;
				}
				if (next != null) {
					TreeLinkNode second = next.left == null ? next.right : next.left;
					first.next = second;
				}
			}
			cur = next;
		}
		
		if (root != null) {
			TreeLinkNode left = null;
			while (left == null && root != null) {
				left = root.left == null ? root.right : root.left;
				root = root.next;
			}
			if (left != null) connect(left);
		}
	}
	
	public static void main(String[] args) {
		long res = 0;
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		TreeLinkNode root = TreeLinkNode.generate(nums);
//		root.left.left = null;
		
		PopulatingNextII nextII = new PopulatingNextII();
		nextII.connect(root);
		System.out.println("finished");
	}
}
