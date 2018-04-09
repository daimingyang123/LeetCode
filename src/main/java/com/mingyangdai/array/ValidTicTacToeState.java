package com.mingyangdai.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2018/4/4
 */
public class ValidTicTacToeState {
    
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        
        for (int i = 0; i < 3; i++) {
            char[] array = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                char c = array[j];
                if (c == 'X') x++;
                else if (c == 'O') o++;
                
                HashSet<Character> set = row.getOrDefault(i, new HashSet<>());
                set.add(c);
                row.put(i, set);
                set = col.getOrDefault(j, new HashSet<>());
                set.add(c);
                col.put(j, set);
                
                if (i == j) set1.add(c);
                if (i + j == 2) set2.add(c);
            }
        }
        
        //sum
        if (x < o || x > o + 1) return false;
        
        //row
        int count = 0;
        for (Map.Entry<Integer, HashSet<Character>> entry : row.entrySet()) {
            HashSet<Character> set = entry.getValue();
            if (set.size() == 1) {
                if (set.contains(' ')) continue;
                if (!valid(set, x, o)) return false;
                count++;
            }
        }
        if (count >= 2) return false;
        
        //col
        count = 0;
        for (Map.Entry<Integer, HashSet<Character>> entry : col.entrySet()) {
            HashSet<Character> set = entry.getValue();
            if (set.size() == 1) {
                if (set.contains(' ')) continue;
                if (!valid(set, x, o)) return false;
                count++;
            }
        }
        if (count >= 2) return false;
        
        //dia
        if (set1.size() == 1 && !valid(set1, x, o)) return false;
        if (set2.size() == 1 && !valid(set2, x, o)) return false;
        
        return true;
    }
    
    private boolean valid(HashSet<Character> set, int x, int o) {
        if (set.contains('X')) return x == o + 1;
        return x == o;
    }
    
    public static void main(String[] args) {
        String[] board = new String[]{"XO ","   ","X  "};
        boolean res = new ValidTicTacToeState().validTicTacToe(board);
        System.out.println(res);
    }
}
