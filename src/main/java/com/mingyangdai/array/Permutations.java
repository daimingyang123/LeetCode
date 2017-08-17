package com.mingyangdai.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/9
 */
public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(nums[i])) continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	private boolean[] visited;
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		visited = new boolean[nums.length];
		List<List<Integer>> res = new ArrayList<>();
		permute(nums, new ArrayList<>(), res);
		return res;
	}
	
	private void permute(int[] nums, List<Integer> cur, List<List<Integer>> res) {
		if (cur.size() == nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i=0; i<nums.length; i++) {
			if (visited[i]) continue;
			if (i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
			cur.add(nums[i]);
			visited[i] = true;
			permute(nums, cur, res);
			cur.remove(cur.size()-1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		Permutations permutations = new Permutations();
		List<List<Integer>> res = permutations.permuteUnique(nums);
		System.out.println(res);
	}
}
