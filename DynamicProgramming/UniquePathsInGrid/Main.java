package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] testMatrix = {
                {0, 0, 0},
                {0, 0, 0}
        };

        Main m = new Main();
        System.out.println(m.uniquePathsWithObstacles(testMatrix));
    }

    public int uniquePathsWithObstacles(int[][] A) {
        int numRows = A.length;
        if(numRows == 0) return 0;

        int numCols = A[0].length;

        int[][] cache = new int[numRows + 1][numCols + 1];

        for(int i = 0; i < numRows; i++){
            cache[i][0] = 0;
        }

        for(int i = 0; i < numCols; i++){
            cache[0][i] = 0;
        }

        if(A[0][0] == 1){
            cache[1][0] = 0;
        } else {
            cache[1][0] = 1;
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(A[i][j] == 0){
                    cache[i + 1][j + 1] = cache[i + 1][j] + cache[i][j + 1];
                } else {
                    cache[i + 1][j + 1] = 0;
                }
            }
        }
        return cache[numRows][numCols];
    }

    // Recursive Solution
    // public int uniquePathsWithObstacles(int[][] A) {
    //     int numRows = A.length;
    //     if(numRows == 0) return 0;
    //
    //     int numCols = A[0].length;
    //
    //     return uniquePathsHelper(A, 0, 0, numRows - 1, numCols - 1);
    // }
    //
    // private int uniquePathsHelper(int[][] matrix, int i, int j, int m, int n){
    //     if(i > m || j > n || matrix[i][j] == 1) return 0;
    //
    //     if(i == m && j == n) return 1;
    //
    //     int numPathsBelow = uniquePathsHelper(matrix, i + 1, j, m, n);
    //     int numPathsRight = uniquePathsHelper(matrix, i, j + 1, m, n);
    //
    //     return numPathsBelow + numPathsRight;
    // }
}
