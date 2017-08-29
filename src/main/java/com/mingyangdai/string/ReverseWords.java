package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/8/29
 */
public class ReverseWords {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        for (int i = 0; i < s.length; i++) {
            for (int j = i+1; j < s.length; j++) {
                if (s[j] == ' ') {
                    reverse(s, i, j-1);
                    i = j;
                    break;
                } else if (j == s.length-1) {
                    reverse(s, i, j);
                    i = j;
                    break;
                }
            }
        }
    }
    
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char c = array[start];
            array[start] = array[end];
            array[end] = c;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        char[] s = "the sky is blue".toCharArray();
        words.reverseWords(s);
        System.out.println(new String(s));
    }
}
