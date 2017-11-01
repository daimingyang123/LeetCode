package com.mingyangdai.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/10/28
 */
public class SerializeandDeserializeBinaryTree {
	
	private static final String spliter = ",";
	private static final String NN = "X";
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.val).append(spliter);
			buildString(node.left, sb);
			buildString(node.right,sb);
		}
	}
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}
	
	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN)) return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
	
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree binaryTree = new SerializeandDeserializeBinaryTree();
		int[] nums = {1,2,3};
//		TreeNode root = TreeNode.generate(nums);
		
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		
		root.left = t2;
		t2.left = t3;
		t3.left = t4;
		t4.left = t5;
		
		String data = binaryTree.serialize(root);
		root = binaryTree.deserialize(data);
		TreeNode.traverse(root);
	}
}
