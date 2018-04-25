package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2018/4/22
 */
public class ShortEncodingofWords {
	class TrieNode {
		TrieNode[] links;
	}
	
	class TrieTree {
		TrieNode root;
		public TrieTree() {
			root = new TrieNode();
		}
		
		private int getLength(String word) {
			int res = 0;
			char[] array = word.toCharArray();
			TrieNode node = root;
			
			for (int i = array.length - 1; i >= 0; i--) {
				int index = array[i] - 'a';
				if (node.links == null) {
					node.links = new TrieNode[26];
					node.links[index] = new TrieNode();
					res++;
				} else if (node.links[index] == null) {
					node.links[index] = new TrieNode();
					res = array.length - i;
				}
				node = node.links[index];
			}
			return res;
		}
	}
	
	public int minimumLengthEncoding(String[] words) {
		int res = 0;
		TrieTree tree = new TrieTree();
		for (String word : words) {
			int length = tree.getLength(word);
			if (length == word.length()) length++;
			res += length;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = new String[]{"atime", "time", "btime"};
		int res = new ShortEncodingofWords().minimumLengthEncoding(words);
		System.out.println(res);
	}
}
