package com.mingyangdai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/6/27
 */
public class TextJustification {
	
	private int index = 0;
	
	public static void main(String[] args) {
		TextJustification justification = new TextJustification();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int length = 16;
		Queue<String> queue = new LinkedList<String>();
		List<String> result = justification.fullJustify(words, length);
		System.out.println(result);
	}
	
	public List<String> fullJustify2(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		
		while (index < words.length) {
			String line = getLine(words, maxWidth);
			result.add(line);
			index++;
		}
		return result;
	}
	
	private String getLine(String[] words, int maxWidth) {
		int start = index, length = 0;
		
		String s;
		while (index < words.length) {
			s = words[index];
			if (length + s.length() == maxWidth) {
				length = maxWidth + 1;
				break;
			}
			if (length + s.length() + 1 > maxWidth) {
				index--;
				break;
			}
			index++;
			length += s.length() + 1;
		}
		if (index == words.length) index = words.length - 1;
		
		//final line
		if (index == words.length - 1) {
			StringBuilder line = new StringBuilder();
			while (start < index) {
				line.append(words[start++]);
				line.append(" ");
			}
			line.append(words[start]);
			line.append(getSpaces(maxWidth - line.length()));
			return line.toString();
		}
		
		length -= 1;
		int inter = index - start;
		//only one word
		if (inter == 0) {
			StringBuilder line = new StringBuilder(words[start]);
			line.append(getSpaces(maxWidth - line.length()));
			return line.toString();
		}
		
		int space = (maxWidth - length) / inter + 1;
		int extra = (maxWidth - length) % inter;
		String spaces = getSpaces(space);
		
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < extra; i++) {
			line.append(words[start++]);
			line.append(spaces);
			line.append(" ");
		}
		
		while (start < index) {
			line.append(words[start++]);
			line.append(spaces);
		}
		
		line.append(words[start]);
		return line.toString();
	}
	
	private String getSpaces(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append(" ");
		}
		return builder.toString();
	}
	
	public List<String> fullJustify(String[] words, int L) {
		List<String> lines = new ArrayList<String>();
		
		int index = 0;
		while (index < words.length) {
			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > L) break;
				count += words[last].length() + 1;
				last++;
			}
			
			StringBuilder builder = new StringBuilder();
			int diff = last - index - 1;
			// if last line or number of words in the line is 1, left-justified
			if (last == words.length || diff == 0) {
				for (int i = index; i < last; i++) {
					builder.append(words[i] + " ");
				}
				builder.deleteCharAt(builder.length() - 1);
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {
				// middle justified
				int spaces = (L - count) / diff;
				int r = (L - count) % diff;
				for (int i = index; i < last; i++) {
					builder.append(words[i]);
					if (i < last - 1) {
						for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
							builder.append(" ");
						}
					}
				}
			}
			lines.add(builder.toString());
			index = last;
		}
		
		
		return lines;
	}
	
}
