package com.mingyangdai.bfs;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/12/23
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> words = new HashSet<>();
		words.addAll(wordList);
		if (!words.contains(endWord)) return 0;
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int length = 1;
		while (!queue.isEmpty()) {
			Queue<String> queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {
				beginWord = queue.poll();
				HashSet<String> wordsWithinDistance = getWordsWithinDistance(beginWord, words);
				if (wordsWithinDistance.contains(endWord)) return length + 1;
				queue2.addAll(wordsWithinDistance);
			}
			length ++;
			queue = queue2;
		}
		
		return 0;
	}
	
	private HashSet<String> getWordsWithinDistance(String word, HashSet<String> wordList) {
		HashSet<String> set = new HashSet<>();
		char[] array = word.toCharArray();
		for (int i=0; i<array.length; i++) {
			char origin = array[i];
			for (int j=0; j<24; j++) {
				char c = (char) ('a' + j);
				if (c == origin) continue;
				array[i] = c;
				String s = new String(array);
				if (wordList.remove(s)) {
					set.add(s);
				}
			}
			array[i] = origin;
		}
		return set;
	}
	
	public static void main(String[] args) {
		WordLadder ladder = new WordLadder();
		String begin = "game";
		String end = "thee";
		List<String> wordList = Lists.newArrayList("frye","heat","tree","thee","game","free","hell","fame","faye");
		int length = ladder.ladderLength(begin, end, wordList);
		System.out.println(length);
	}
}
