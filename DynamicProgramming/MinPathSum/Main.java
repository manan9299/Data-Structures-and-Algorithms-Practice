package com.company;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[][] testMatrix = {
                {1, 3, 2},
                {4, 3, 1},
                {5, 6, 1}
        };

        System.out.println(m.minPathSum(testMatrix));
    }

    public int minPathSum(int[][] A) {
        int numRows = A.length;
        if(numRows == 0) return 0;

        int numCols = A[0].length;

        int[][] cache = new int[numRows][numCols];
        cache[0][0] = A[0][0];

        for(int i = 1; i < numRows; i++){
            cache[i][0] = cache[i - 1][0] + A[i][0];
        }

        for(int i = 1; i < numCols; i++){
            cache[0][i] = cache[0][i - 1] + A[0][i];
        }

        for(int i = 1; i < numRows; i++){
            for(int j = 1; j < numCols; j++){
                cache[i][j] = Math.min(cache[i - 1][j] + A[i][j], cache[i][j - 1] + A[i][j]);
            }
        }

        return cache[numRows - 1][numCols - 1];
    }

    // Recursive Solution
    // public int minPathSum(int[][] A) {
    //     int numRows = A.length;
    //     if(numRows == 0) return 0;
    //
    //     int numCols = A[0].length;
    //
    //     return minPathSumHelper(A, 0, 0, 0, numRows - 1, numCols - 1);
    // }
    //
    // public int minPathSumHelper(int[][] matrix, int rowIdx, int colIdx, int curSum, int numRows, int numCols){
    //     if(rowIdx > numRows || colIdx > numCols) return Integer.MAX_VALUE;
    //
    //     if((rowIdx == numRows) && (colIdx == numCols)) return (curSum + matrix[rowIdx][colIdx]);
    //
    //     int updatedSum = curSum + matrix[rowIdx][colIdx];
    //     int sumBelow = minPathSumHelper(matrix, rowIdx + 1, colIdx, updatedSum, numRows, numCols);
    //     int sumRight = minPathSumHelper(matrix, rowIdx, colIdx + 1, updatedSum, numRows, numCols);
    //
    //     return Math.min(sumBelow, sumRight);
    // }
}
