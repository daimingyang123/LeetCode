package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/5/27
 */
public class MagicSquaresInGrid {
	public int numMagicSquaresInside(int[][] grid) {
		int count = 0;
		
		for (int rowStart = 0; rowStart <= grid.length - 3; rowStart++) {
			for (int colStart = 0; colStart <= grid[0].length - 3; colStart++) {
				int[] row = new int[3], col = new int[3], diagonal = new int[2];
				
				int rowEnd = rowStart + 3;
				boolean valid = true;
				for (int i = rowStart; i < rowEnd; i++) {
					int colEnd = colStart + 3;
					for (int j = colStart; j < colEnd; j++) {
						if (grid[i][j] < 0 || grid[i][j] > 9) valid = false;
						
						row[i - rowStart] += grid[i][j];
						col[j - colStart] += grid[i][j];
						if (i - j == rowStart - colStart) diagonal[0] += grid[i][j];
						if (i + j == rowStart + colEnd - 1) diagonal[1] += grid[i][j];
					}
				}
				if (valid && isValid(row, col, diagonal)) count++;
			}
		}
		
		return count;
	}
	
	private boolean isValid(int[] row, int[] col, int[] diagonal) {
		for (int i = 0; i < 3; i++) {
			if (row[i] != 15 || col[i] != 15) return false;
		}
		if (diagonal[0] != 15 || diagonal[1] != 15) return false;
		return true;
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][]{{3,10,2,3,4}, {4,5,6,8,1}, {8,8,1,6,8}, {1,3,5,7,1},{9,4,9,2,9}};
		int res = new MagicSquaresInGrid().numMagicSquaresInside(grid);
		System.out.println(res);
	}
}
