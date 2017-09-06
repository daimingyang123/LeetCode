package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/8/30
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setRow(matrix, i);
                    setCol(matrix, j);
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }
    
    private void setRow(int[][] matrix, int row) {
        for(int i=0; i<matrix[0].length; i++) {
            if (matrix[row][i] == 0) continue;
            matrix[row][i] = -1;
        }
    }
    
    private void setCol(int[][] matrix, int col) {
        for(int i=0; i<matrix.length; i++) {
            if (matrix[i][col] == 0) continue;
            matrix[i][col] = -1;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,1},
                {1,2,2,2}
        };
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        zeroes.setZeroes(matrix);
        System.out.println(matrix);
    }
}
