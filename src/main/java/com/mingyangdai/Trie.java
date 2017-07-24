package com.mingyangdai;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2017/6/28
 */
public class Trie {
	
	private Character c;
	private boolean isWord = false;
	private HashSet<Trie> tries = new HashSet();
	
	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		if (getCharacter() == null) setCharacter(' ');
	}
	
	public static void main(String[] args) {
		HashSet<Trie> set = new HashSet<Trie>();
		Trie trie = new Trie();
		trie.insert("a");
		boolean result = trie.search("a");
		System.out.println(result);
	}
	
	public Character getCharacter() {
		return c;
	}
	
	public void setCharacter(Character c) {
		this.c = c;
	}
	
	public boolean getIsWord() {
		return isWord;
	}
	
	public void setIsWord(boolean isWord) {
		this.isWord = isWord;
	}
	
	public HashSet<Trie> getTries() {
		return tries;
	}
	
	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		Trie trie = new Trie();
		trie.setCharacter(word.charAt(0));
		
		Trie root = getTrie(getTries(), trie);
		if (root == null) {
			getTries().add(trie);
			root = trie;
		}
		if (word.length() == 1) root.setIsWord(true);
		
		int start = 1;
		while (start < word.length()) {
			HashSet<Trie> tries = root.getTries();
			trie = new Trie();
			trie.setCharacter(word.charAt(start));
			if (tries.contains(trie)) {
				trie = getTrie(tries, trie);
			} else {
				tries.add(trie);
			}
			if (start == word.length() - 1) trie.setIsWord(true);
			
			root = trie;
			start++;
		}
	}
	
	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		Trie trie = new Trie();
		trie.setCharacter(word.charAt(0));
		
		Trie root = getTrie(getTries(), trie);
		if (root == null) return false;
		if (word.length() == 1 && !root.getIsWord()) return false;
		
		for (int i = 1; i < word.length(); i++) {
			Trie target = new Trie();
			target.setCharacter(word.charAt(i));
			
			HashSet<Trie> set = root.getTries();
			root = getTrie(set, target);
			if (root == null) return false;
			if (i == word.length() - 1 && !root.getIsWord()) return false;
		}
		
		return true;
	}
	
	private Trie getTrie(HashSet<Trie> set, Trie target) {
		if (!set.contains(target)) return null;
		for (Trie trie : set) {
			if (trie.equals(target)) return trie;
		}
		return null;
	}
	
	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie trie = new Trie();
		trie.setCharacter(prefix.charAt(0));
		
		Trie root = getTrie(getTries(), trie);
		if (root == null) return false;
		
		for (int i = 1; i < prefix.length(); i++) {
			Trie target = new Trie();
			target.setCharacter(prefix.charAt(i));
			
			HashSet<Trie> set = root.getTries();
			root = getTrie(set, target);
			if (root == null) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return getCharacter();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.c == ((Trie) obj).getCharacter();
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


