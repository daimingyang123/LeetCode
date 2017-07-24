package com.mingyangdai;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2017/5/6
 */
public class MapProblems {
	
	public static void main(String[] args) {
		MapProblems problems = new MapProblems();
		int[] nums = {1, 6, 4, 10, 2};
		String[] result = problems.findRelativeRanks(nums);
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	public int islandPerimeter(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) count += count(i, j, grid);
			}
		}
		return count;
	}
	
	private int count(int x, int y, int[][] grid) {
		int count = 0;
		if (x == 0 || grid[x - 1][y] == 0) count++;
		if (x == grid[0].length - 1 || grid[x + 1][y] == 0) count++;
		if (y == 0 || grid[x][y - 1] == 0) count++;
		if (y == grid.length - 1 || grid[x][y + 1] == 0) count++;
		return count;
	}
	
	public String[] findRelativeRanks(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		String[] metals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
		String[] result = new String[nums.length];
		
		Integer index;
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			index = entry.getValue();
			if (i < metals.length) {
				result[index] = metals[i];
			} else {
				result[index] = Integer.toString(i + 1);
			}
			i++;
		}
		
		return result;
	}
}
