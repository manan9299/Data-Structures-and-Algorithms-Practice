package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0}
        };

        System.out.println(maximalRectangle(matrix1));

        int[][] matrix2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println(maximalRectangle(matrix2));
    }

    public static int maximalRectangle(int[][] A) {
        int numRows = A.length;
        int numCols = A[0].length;

        int[][] width = new int[numRows][numCols];

        for(int i = 0; i < numRows; i++)
            width[i][0] = A[i][0];

        for(int i = 0; i < numRows; i++){
            for(int j = 1; j < numCols; j++){
                if(A[i][j] == 1)
                    width[i][j] = width[i][j - 1] + 1;
            }
        }

        int maxArea = 0;

        for(int k = 0; k < numCols; k++){

            for(int i = 0; i < numRows; i++){
                int minWidth = Integer.MAX_VALUE;
                for(int j = i; j < numRows; j++){

                    minWidth = Math.min(width[j][k], minWidth);
                    int curArea = minWidth * (j - i + 1);

                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }

        // Print row wise cumulative sum
        // for(int i = 0; i < numRows; i++){
        //     for(int j = 0; j < numCols; j++){
        //         System.out.print(width[i][j] + " | ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        return maxArea;
    }
}
