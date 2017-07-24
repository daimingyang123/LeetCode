package com.mingyangdai;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 17/4/2
 */
public class Top {
	
	public static void main(String[] args) {
		int[][] nums = {
				{8, 7, 5},
				{9, 5, 2},
				{3, 2, 0}
		};
		
	}
	
	public List<Integer> topKNumbers(int[][] numbers, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if (k == 0) return result;
		int max = 0;
		//每行内部排序
		Interval[] array = new Interval[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int[] sub = numbers[i];
			Arrays.sort(sub);
			max += sub[0];
			array[i] = new Interval(0, sub);
		}
		result.add(max);
		if (k == 1) return result;
		
		int subLen = numbers[0].length;
		//之后根据index与index+1的差值排序
		while (k > 0) {
			Arrays.sort(array);
			int index = 0;
			int sum = 0;
			for (int i = 0; i < 1; i++) {
				sum = array[index].nums[i];
				
				for (int j = 0; j < numbers.length; j++) {
					sum += numbers[j][index];
				}
			}
			
			k--;
		}
		
		return result;
	}
	
	class Interval implements Comparable<Interval> {
		int index;
		int[] nums;
		
		public Interval(int index, int[] nums) {
			this.index = index;
			this.nums = nums;
		}
		
		@Override
		public int compareTo(Interval o) {
			int interval1 = nums[index + 1] - nums[index];
			int interval2 = o.nums[index + 1] - o.nums[index];
			return interval2 - interval1;
		}
	}
}
