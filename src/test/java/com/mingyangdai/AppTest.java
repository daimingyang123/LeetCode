package com.mingyangdai;

import java.util.HashSet;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static final HashSet<Character> set = new HashSet<>();
	static {
		set.add('b');
	}
	
	
	
	class Trie {
		public char val;
		public Trie[] childs;
		public boolean isEnd;
		
		public Trie (char val) {
			this.val = val;
			this.childs = new Trie[26];
			this.isEnd = false;
		}
	}
	
	class TrieTree {
		Trie root;
		
		public TrieTree () {
			root = new Trie('a');
		}
		
		private void insert(String word) {
			Trie p = root;
			for (char c : word.toCharArray()) {
				Trie s = new Trie(c);
				p.childs[c - 'a'] = s;
				p = s;
			}
			p.isEnd = true;
		}
		
		private boolean canBreak(char[] array, int i, Boolean[] dp) {
			if (i == array.length) return true;
			if (dp[i] != null) return dp[i];
			
			HashSet<Integer> set = search(array, i);
			for (Integer j : set) {
				if (canBreak(array, j, dp)) {
					dp[i] = true;
					return dp[i];
				}
			}
			dp[i] = false;
			return dp[i];
		}
		
		public HashSet<Integer> search(char[] array, int i) {
			HashSet<Integer> set = new HashSet<>();
			Trie p = root;
			while (i < array.length) {
				Trie s = p.childs[array[i] - 'a'];
				if (s == null) return set;
				p = s;
				i++;
				if (p.isEnd) set.add(i);
			}
			return set;
		}
		
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
		TrieTree tree = buildTree(wordDict);
		return tree.canBreak(s.toCharArray(), 0, new Boolean[s.length()]);
	}
	
	private TrieTree buildTree(List<String> wordDict) {
		TrieTree tree = new TrieTree();
		for (String word : wordDict) {
			tree.insert(word);
		}
		return tree;
	}
	
	public static void main(String[] args) {
		String s1 = "";
		String s2 = new String(s1);
	}
}
