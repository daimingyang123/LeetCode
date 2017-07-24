package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/7/2
 */
public class WordSearchII {
	
	public static void main(String[] args) {
		WordSearchII wordSearchII = new WordSearchII();
		char[][] board =
				{
						{'o', 'a', 'a', 'n'},
						{'e', 't', 'a', 'e'},
						{'i', 'h', 'k', 'r'},
						{'i', 'f', 'l', 'v'}
				};
		
		String[] words = {"oath", "pea", "eat", "rain"};
		List<String> result = wordSearchII.findWords(board, words);
		System.out.println(result);
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie root = buildTree(words);
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				findWords(board, i, j, root, res);
			}
		}
		
		return res;
	}
	
	private void findWords(char[][] board, int i, int j, Trie root, List<String> res) {
		char c = board[i][j];
		if (board[i][j] == '*' || root.tries[c - 'a'] == null) return;
		root = root.tries[c - 'a'];
		String word = root.word;
		if (word != null) {
			res.add(word);
			root.word = null;
		}
		
		board[i][j] = '*';
		if (i > 0) findWords(board, i - 1, j, root, res);
		if (j > 0) findWords(board, i, j - 1, root, res);
		if (i < board.length - 1) findWords(board, i + 1, j, root, res);
		if (j < board[0].length - 1) findWords(board, i, j + 1, root, res);
		board[i][j] = c;
	}
	
	private Trie buildTree(String[] words) {
		Trie root = new Trie(' ');
		
		for (String word : words) {
			Trie head = root;
			for (char c : word.toCharArray()) {
				Trie trie = new Trie(c);
				if (head.tries[c - 'a'] == null) {
					head.tries[c - 'a'] = trie;
				} else {
					trie = head.tries[c - 'a'];
				}
				head = trie;
			}
			head.word = word;
		}
		
		return root;
	}
	
	class Trie {
		char c;
		Trie[] tries = new Trie[26];
		String word;
		
		public Trie(char c) {
			this.c = c;
		}
	}
}
