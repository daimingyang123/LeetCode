package com.mingyangdai.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2018/10/6
 */
public class WordDictionary {
	
	private class TreeNode {
		TreeNode[] array;
		boolean isEnd;
	}
	
	private TreeNode root;
	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TreeNode();
	}
	
	/** Adds a word into the data structure. */
	public void addWord(String word) {
		char[] array = word.toCharArray();
		
		TreeNode node = root;
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (node.array == null) {
				node.array = new TreeNode[26];
			}
			if (node.array[c - 'a'] == null) {
				node.array[c - 'a'] = new TreeNode();
			}
			node = node.array[c - 'a'];
			if (i == array.length - 1) {
				node.isEnd = true;
			}
		}
	}
	
	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length; i++) {
			Queue<TreeNode> queue2 = new LinkedList<>();
			
			if (array[i] == '.') {
				while (!queue.isEmpty()) {
					TreeNode[] nodes = queue.poll().array;
					if (nodes == null) {
						continue;
					}
					for (TreeNode treeNode : nodes) {
						if (treeNode != null) {
							queue2.offer(treeNode);
						}
					}
				}
				queue = queue2;
				continue;
			}
			
			if (queue.isEmpty()) {
				return false;
			}
			
			while (!queue.isEmpty()) {
				TreeNode[] nodes = queue.poll().array;
				if (nodes == null) {
					continue;
				}
				TreeNode node = nodes[array[i] - 'a'];
				if (i == array.length - 1 && node != null && node.isEnd == true) {
					queue2.offer(node);
				}
				if (i != array.length - 1 && node != null) {
					queue2.offer(node);
				}
			}
			queue = queue2;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.addWord("bad");
		dictionary.addWord("dad");
		dictionary.addWord("mad");
		boolean res = dictionary.search("pad");
		System.out.println(res);
		res = dictionary.search("bad");
		System.out.println(res);
		res = dictionary.search(".ad");
		System.out.println(res);
		res = dictionary.search("b..");
		System.out.println(res);
	}
}
