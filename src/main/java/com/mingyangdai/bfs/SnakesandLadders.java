package com.mingyangdai.bfs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2018/9/23
 */
public class SnakesandLadders {
	
	public int snakesAndLadders(int[][] board) {
		HashMap<Integer, int[]> map = new HashMap<>();
		int square = 1;
		boolean flag = true;
		
		for (int i = board.length - 1; i >= 0; i--) {
			if (flag) {
				for (int j = 0; j < board[0].length; j++) {
					map.put(square++, new int[]{i, j});
				}
			} else {
				for (int j = board[0].length - 1; j >= 0; j--) {
					map.put(square++, new int[]{i, j});
				}
			}
			flag = !flag;
		}
		
		return solve(map, square - 1, board);
	}
	
	private int solve(HashMap<Integer, int[]> map, int target, int[][] board) {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		int moves = 0;
		
		while (!set.isEmpty()) {
			if (set.contains(target)) {
				return moves;
			}
			HashSet<Integer> set2 = new HashSet<>();
			for (int cur : set) {
				for (int i = 1; i <= 6 && cur + i <= target; i++) {
					int next = cur + i;
					int[] array = map.get(next);
					int val = board[array[0]][array[1]];
					if (val == cur) {
						continue;
					} else if (val == -1) {
						set2.add(next);
					} else {
						set2.add(val);
					}
				}
			}
			moves++;
			set = set2;
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		int[][] board = new int[][]{
				{1,1,-1},{1,1,1},{-1,1,1}
		};
		int res = new SnakesandLadders().snakesAndLadders(board);
		System.out.println(res);
	}
}
