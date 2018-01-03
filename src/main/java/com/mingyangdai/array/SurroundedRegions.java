package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/12/31
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length == 0) return;
		
		int[] nums = {0, board.length};
		for (int i : nums) {
			for (int j=0; j<board[0].length; j++) {
				mark(board, i, j);
			}
		}
		int[] array = {0, board[0].length};
		for (int i : array) {
			for (int j=0; j<board.length; j++) {
				mark(board, i, j);
			}
		}
		for (int i=0; i<board.length; i++) {
			for (int j=0; j>board[0].length; j++) {
				switch (board[i][j]) {
					case 'O':
						board[i][j] = 'X';
						break;
					case 'F':
						board[i][j] = 'O';
						break;
				}
			}
		}
	}
	
	private void mark(char[][] board, int i, int j) {
		if (board[i][j] != 'O') return;
		board[i][j] = 'F';
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};
		for (int k=0; k<4; k++) {
			int m = i + x[k];
			int n = j + y[k];
			if (m>0 && m<board.length && n>0 && n<board[0].length) {
				mark(board, m, n);
			}
		}
	}
}
