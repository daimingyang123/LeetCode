package com.mingyangdai;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mingyang.dai
 * @since 17/3/6
 */
public class Unique {
	
	private static TreeNode real;
	
	public static void main(String[] args) {
		Unique unique = new Unique();
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);

//        four.right = three;
//        three.right = five;
//        five.left = two;
//        five.right = six;
//        unique.recoverTree(four);

//        three.right = two;
//        two.right = one;
//        unique.recoverTree(three);
		
		four.left = two;
		two.right = three;
		three.left = one;
//        unique.recoverTree(four);

//        three.left = one;
//        one.right = two;
//        two.right = four;
//        unique.recoverTree(three);
		
		System.out.println(null != null);
//        System.out.println("finish");
		Set<Integer> set = new HashSet<Integer>();
	}
	
	public void recoverTree(TreeNode root) {
		if (root != null) {
			real = root;
			checkFromRoot();
		}
	}
	
	private void checkFromRoot() {
		checkNode(real);
		if (real.left != null) checkLeftChild(true, real, real, real.left);
		if (real.right != null) checkRightChild(false, real, real, real.right);
	}
	
	private void checkNode(TreeNode root) {
		if (root.left != null && root.left.val > root.val) {
			swap(root.left, root);
			checkFromRoot();
		}
		if (root.right != null && root.right.val < root.val) {
			swap(root.right, root);
			checkFromRoot();
		}
	}
	
	private void checkLeftChild(boolean isLeft, TreeNode root, TreeNode parent, TreeNode cur) {
		if (cur.left != null) {
			if (cur.left.val > cur.val) {
				swap(cur.left, cur);
				checkFromRoot();
			}
			if (!isLeft && cur.left.val < root.val) {
				swap(cur.left, root);
			}
		}
		
		if (cur.right != null) {
			if (cur.right.val < cur.val) {
				swap(cur.right, cur);
				checkFromRoot();
			}
			if (cur.right.val > parent.val) {
				swap(cur.right, parent);
				checkFromRoot();
			}
		}
		
		if (cur.left != null) checkLeftChild(true, parent, cur, cur.left);
		if (cur.right != null) checkRightChild(true, parent, cur, cur.right);
	}
	
	private void checkRightChild(boolean isLeft, TreeNode root, TreeNode parent, TreeNode cur) {
		if (cur.left != null) {
			if (cur.left.val > cur.val) {
				swap(cur.left, cur);
				checkFromRoot();
			}
			if (cur.left.val < parent.val) {
				swap(cur.left, parent);
				checkFromRoot();
			}
		}
		
		if (cur.right != null) {
			if (cur.right.val < cur.val) {
				swap(cur.right, cur);
				checkFromRoot();
			}
			if (isLeft && cur.right.val > root.val) {
				swap(cur.right, root);
				checkFromRoot();
			}
		}
		
		if (cur.left != null) checkLeftChild(false, parent, cur, cur.left);
		if (cur.right != null) checkRightChild(false, parent, cur, cur.right);
	}
	
	private void swap(TreeNode first, TreeNode second) {
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
}
