package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/6/30
 */
public class Analysis {
	
	public static void main(String[] args) {
		String mine = "";
		
		String answ = "";
		
		System.out.println(mine.equals(answ));
		
		String[] mines = mine.split(",");
		String[] answs = answ.split(",");
		
		for (int i = 0; i < mines.length; i++) {
			if (!mines[i].equals(answs[i])) {
				System.out.println(i);
				break;
			}
		}
		
		Trie trie = new Trie();
		String target = "";
		
		String operation = "";
		String word = "";
		
		String[] opers = operation.split(" ");
		String[] words = word.split(" ");
		
		String single;
		int i = 0;
		while (i < 1244) {
			if (opers[i].contains("insert")) {
				single = words[i].substring(2, words[i].length() - 2);
				trie.insert(single);
			}
			i++;
		}
		
		while (i < 1664) {
			if (opers[i].contains("insert")) {
				single = words[i].substring(2, words[i].length() - 2);
				trie.insert(single);
			}
			if (i == 1620) {
				System.out.println("fuck");
			}
			if (!trie.search(target)) {
				System.out.println("oper=" + opers[i]);
				System.out.println("i=" + i);
				System.out.print(words[i]);
				break;
			}
			i++;
		}
		
		System.out.println("finish");
	}
}
