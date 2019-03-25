package com.mingyangdai;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return 0;
        
        HashSet<String> queue = new HashSet<>();
        queue.add(beginWord);
        
        int dis = 2;
        while (!queue.isEmpty()) {
            HashSet<String> queue2 = new HashSet<>();
            for (String word : queue) {
                HashSet<String> set = getSet(word, wordSet);
                if (set.contains(endWord)) return dis;
                queue2.addAll(set);
                dis++;
            }
            queue = queue2;
        }
        
        return 0;
    }
    
    private HashSet<String> getSet(String word, HashSet<String> wordSet) {
        HashSet<String> set = new HashSet<>();
        char[] array = word.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == c) continue;
                array[i] = j;
                String s = new String(array);
                if (wordSet.remove(s)) {
                    set.add(s);
                }
            }
            array[i] = c;
        }
        
        return set;
    }
    
	public static void main(String[] args) {
        String beginWord = "hit";
        String end = "cog";
        List<String> list = Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog");
        int dis = new AppTest().ladderLength(beginWord, end, list);
        System.out.println(dis);
	}
}
