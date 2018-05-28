package com.mingyangdai.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/4/29
 */
public class FriendsOfAppropriateAges {
	class Range {
		public int start;
		public int end;
		
		public Range(int start) {
			this.start = start;
		}
	}
	
	public int numFriendRequests(int[] ages) {
		Arrays.sort(ages);
		TreeSet<Integer> set = new TreeSet<>();
		HashMap<Integer, Range> map = new HashMap<>();
		for (int i = 0; i < ages.length; i++) {
			set.add(ages[i]);
			Range range = map.getOrDefault(ages[i], new Range(i));
			range.end = i;
			map.put(ages[i], range);
		}
		
		int res = 0;
		for (int age : ages) {
			if (age < 14) continue;
			
			Integer min = set.higher((age >> 1) + 7);
			if (min == null) continue;
			Range minRange = map.get(min);
			
			Integer max = set.floor(age);
			Range maxRange = map.get(max);
			
			res += maxRange.end - minRange.start;
			if (max != min) res += 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] ages = new int[]{16,16};
		int res = new FriendsOfAppropriateAges().numFriendRequests(ages);
		System.out.println(res);
	}
}
