package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 17/4/7
 */
public class TreeProblems {
	
	int min = Integer.MAX_VALUE;
	Integer prev = null;
	
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(236);
		
		TreeNode l2 = new TreeNode(104);
		TreeNode l3 = new TreeNode(701);
		
		TreeNode l4 = new TreeNode(227);
		TreeNode l5 = new TreeNode(911);
		
		
		TreeNode l6 = new TreeNode(7);
		TreeNode l7 = new TreeNode(9);
		
		TreeNode l8 = new TreeNode(1);
		TreeNode l9 = new TreeNode(6);
		
		TreeNode l10 = new TreeNode(1);
		
		l1.left = l2;
		l1.right = l3;
		
		l2.right = l4;
		l3.right = l5;

//        l5.left = l8;
//        l5.right = l9;
		
		
		TreeProblems treeProblems = new TreeProblems();
		int result = treeProblems.getMinimumDifference(l1);
		System.out.println(result);
		
	}

//    private static int sum = 0;
//    private static int count = 0;
//    private static HashSet<List<TreeNode>> set = new HashSet<List<TreeNode>>();
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) return result;
		binaryTreePaths(root, Integer.toString(root.val), result);
		return result;
	}


//    Integer prev = null;
//    int count = 1;
//    int max = 0;
//    public int[] findMode(TreeNode root) {
//        if (root == null) return new int[0];
//
//        List<Integer> list = new ArrayList<Integer>();
//        traverse(root, list);
//
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
//        return res;
//    }

//    private void traverse(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        traverse(root.left, list);
//        if (prev != null) {
//            if (root.val == prev)
//                count++;
//            else
//                count = 1;
//        }
//        if (count > max) {
//            max = count;
//            list.clear();
//            list.add(root.val);
//        } else if (count == max) {
//            list.add(root.val);
//        }
//        prev = root.val;
//        traverse(root.right, list);
//    }
	
	private void binaryTreePaths(TreeNode node, String cur, List<String> result) {
		if (node.left == null && node.right == null) {
			result.add(cur);
			return;
		}
		if (node.left != null) {
			String left = cur + "->" + node.left.val;
			binaryTreePaths(node.left, left, result);
		}
		if (node.right != null) {
			String right = cur + "->" + node.right.val;
			binaryTreePaths(node.right, right, result);
		}
	}
	
	public boolean isPowerOfThree(int n) {
		int tmp = n & (n - 1);
		return tmp == n;
	}
	
	private void traversal(List<TreeNode> list) {
		System.out.println();
		for (TreeNode node : list) {
			System.out.print(node.val);
			System.out.print("->");
		}
		System.out.println();
	}
	
	public int getMinimumDifference(TreeNode root) {
		if (root == null) return min;
		
		getMinimumDifference(root.left);
		
		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;
		
		getMinimumDifference(root.right);
		
		return min;
	}
}
