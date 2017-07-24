package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/6/18
 */
public class ArrayProblems {
	
	int max;

//	public int rob(int[] nums) {
//		Rob[] robs = new Rob[nums.length];
//
//		for (int i=0; i<3; i++) {
//			List<Integer> indexs = new ArrayList<Integer>();
//			indexs.add(i);
//			robs[i] = new Rob(nums[i], indexs);
//		}
//
//		Rob first = getMax(nums, 3, robs);
//		Rob second = getMax(nums, 4, robs);
//
//		Rob max = getMax(first, second);
//		return max.getSum();
//
//	}
	
	public static void main(String[] args) {
		String[] strings = "".split("\\[");
		System.out.println(strings);
		
		ArrayProblems problems = new ArrayProblems();
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		int result = problems.maximalSquare(matrix);
		System.out.println(result);
	}
	
	public int rob(int[] num) {
		int prevNo = 0;
		int prevYes = 0;
		for (int n : num) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n + temp;
		}
		return Math.max(prevNo, prevYes);
	}
	
	private Rob getMax(int[] nums, int start, Rob[] robs) {
		for (int i = start; i < nums.length; i++) {
			if (nums[i - 2] > nums[i - 3]) {
				robs[i] = assemble(nums, i, i - 2, robs);
			} else {
				robs[i] = assemble(nums, i, i - 3, robs);
			}
		}
		
		return getMax(robs[robs.length - 1], robs[robs.length - 2]);
	}
	
	private Rob assemble(int[] nums, int i, int j, Rob[] robs) {
		int sum = nums[i] + robs[j].getSum();
		List<Integer> indexs = new ArrayList<Integer>();
		indexs.add(i);
		indexs.addAll(robs[j].getIndexs());
		return new Rob(sum, indexs);
	}
	
	private Rob getMax(Rob rob1, Rob rob2) {
		if (rob1.getSum() > rob2.getSum()) {
			return rob1;
		} else {
			return rob2;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		int mid = getMid(0, nums.length - 1);
		TreeNode root = new TreeNode(nums[mid]);
		buildTree(nums, 0, nums.length - 1, root);
		return root;
	}
	
	private void buildTree(int[] nums, int start, int end, TreeNode root) {
		if (start > end - 1) return;
		int mid = getMid(start, end);
		
		int leftMid = getMid(start, mid - 1);
		TreeNode left = new TreeNode(nums[leftMid]);
		root.left = left;
		buildTree(nums, start, mid - 1, left);
		
		int rightMid = getMid(mid + 1, end);
		TreeNode right = new TreeNode(nums[rightMid]);
		root.right = right;
		buildTree(nums, mid + 1, end, right);
	}
	
	private int getMid(int start, int end) {
		return (start + end) / 2;
	}
	
	public int maximalSquare2(char[][] matrix) {
		max = 0;
		if (matrix.length == 0) return max;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					count(matrix, i, j);
				}
			}
		}
		
		return max * max;
	}
	
	private void count(char[][] matrix, int rowStart, int colStart) {
		int side = 1;
		boolean flag = false;
		int rowEnd = rowStart, colEnd = colStart;
		
		while (++rowEnd < matrix.length && ++colEnd < matrix[0].length) {
			if (matrix[rowEnd][colStart] != '1' || matrix[rowStart][colEnd] != '1') return;
			
			for (int col = colStart; col <= colEnd; col++) {
				if (matrix[rowEnd][col] == '0') {
					flag = true;
					break;
				}
			}
			
			for (int row = rowStart; row < rowEnd - 1; row++) {
				if (matrix[row][colEnd] == '0') {
					flag = true;
					break;
				}
			}
			
			if (flag) break;
			side++;
		}
		
		max = Math.max(max, side);
	}
	
	public int maximalSquare(char[][] a) {
		if (a.length == 0) return 0;
		int m = a.length, n = a[0].length, result = 0;
		int[][] b = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i - 1][j - 1] == '1') {
					b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
					result = Math.max(b[i][j], result); // update result
				}
			}
		}
		return result * result;
	}
	
	class Rob {
		int sum;
		List<Integer> indexs;
		
		public Rob(int sum, List<Integer> indexs) {
			this.sum = sum;
			this.indexs = indexs;
		}
		
		private int getSum() {
			return sum;
		}
		
		private List<Integer> getIndexs() {
			return indexs;
		}
	}
}
