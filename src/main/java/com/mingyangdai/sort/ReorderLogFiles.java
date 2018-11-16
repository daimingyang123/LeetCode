package com.mingyangdai.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/11/11
 */
public class ReorderLogFiles {
	
	public String[] reorderLogFiles(String[] logs) {
		List<String> letter = new ArrayList<>();
		List<String> digit = new ArrayList<>();
		for (String log : logs) {
			char c = log.split(" ")[1].charAt(0);
			if (Character.isLetter(c)) {
				letter.add(log);
			} else {
				digit.add(log);
			}
		}
		List<String> list = new ArrayList<>();
		letter.sort((o1, o2) -> {
			String[] words1 = o1.split(" ");
			String[] words2 = o2.split(" ");
			for (int i = 1; i < Math.min(words1.length, words2.length); i++) {
				char[] chars1 = words1[i].toCharArray();
				char[] chars2 = words2[i].toCharArray();
				for (int j = 0; j < Math.min(chars1.length, chars2.length); j++) {
					if (chars1[j] != chars2[j]) return chars1[j] - chars2[j];
				}
				return chars1.length - chars2.length;
			}
			return words1.length - words2.length;
		});
		list.addAll(letter);
		list.addAll(digit);
		return list.toArray(new String[list.size()]);
	}
	
	public static void main(String args[]) {
		String[] logs = {"gn j q al","4 j trouka"};
		String[] res = new ReorderLogFiles().reorderLogFiles(logs);
		System.out.println(res);
	}
}
