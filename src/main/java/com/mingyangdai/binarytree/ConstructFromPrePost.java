package com.mingyangdai.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2018/8/19
 */
public class ConstructFromPrePost {
	
	private Map<Integer, Integer> postMap = new HashMap<>();
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		for (int i = 0; i < post.length; i++) {
			postMap.put(post[i], i);
		}
		return construct(pre, 0, pre.length - 1, 0);
	}
	
	private TreeNode construct(int[] pre, int preStart, int preEnd, int postStart) {
		TreeNode root = new TreeNode(pre[preStart]);
		
		int start = preStart + 1;
		if (start > preEnd) return root;
		int length = postMap.get(pre[start]) - postStart;
		int end = start + length;
		int postEnd = postStart + length;
		root.left = construct(pre, start, end, postStart);
		
		start = end + 1;
		if (start > preEnd) return root;
		length = postMap.get(pre[start]) - postEnd - 1;
		end = start + length;
		postStart = postEnd + 1;
		root.right = construct(pre, start, end, postStart);
		
		return root;
	}
	
	public static void main(String args[]) {
		int[] pre = new int[]{9,5,4,10,3,1,2,8,7,6};
		int[] post = new int[]{4,5,7,8,6,2,1,3,10,9};
		TreeNode root = new ConstructFromPrePost().constructFromPrePost(pre, post);
		TreeNode.traverse(root);
	}
}
