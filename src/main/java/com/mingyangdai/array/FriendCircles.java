package com.mingyangdai.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mingyang.dai
 * @since 2017/10/8
 */
public class FriendCircles {
	
	public int findCircleNum(int[][] M) {
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		for (int start=0; start<M.length; start++) {
			if (set.add(start)) {
				count++;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(start);
				while (!queue.isEmpty()) {
					Queue<Integer> queue2 = new LinkedList<>();
					while (!queue.isEmpty()) {
						int i = queue.poll();
						for (int j=0; j<M.length; j++) {
							if (j == i || set.contains(j)) continue;
							if (M[i][j] == 1) queue2.add(j);
						}
					}
					set.addAll(queue2);
					queue = queue2;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] M = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
		FriendCircles circles = new FriendCircles();
		int res = circles.findCircleNum(M);
		System.out.println(res);
	}
}
