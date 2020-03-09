package com.company;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.minDistance("abc", "abd"));
    }

    public int minDistance(String A, String B) {

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for(int i = 0; i < A.length() + 1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i < B.length() + 1; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < A.length() + 1; i++){
            for(int j = 1; j < B.length() + 1; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        //Print dp table
        // for(int i = 0; i < dp.length; i++){
        //     for(int j = 0; j < dp[0].length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[A.length()][B.length()];
        // return minDistanceHelper(A, B, A.length() - 1, B.length() - 1, 0);
    }

    // Recursive Solution
    // public int minDistanceHelper(String A, String B, int i, int j, int curDistance){
    //     // System.out.println("i ==> " + i);
    //     // System.out.println("j ==> " + j);
    //     // System.out.println("curDist ==> " + curDistance);
    //     if(i < 0) return j + 1 + curDistance;
    //     if(j < 0) return i + 1 + curDistance;
    //
    //     if(A.charAt(i) != B.charAt(j)){
    //         int delete = minDistanceHelper(A, B, i - 1, j, curDistance + 1);
    //         int insert = minDistanceHelper(A, B, i, j - 1, curDistance + 1);
    //         int replace = minDistanceHelper(A, B, i - 1, j - 1, curDistance + 1);
    //
    //         return Math.min(replace, Math.min(insert, delete));
    //     }
    //
    //     return minDistanceHelper(A, B, i - 1, j - 1, curDistance);
    // }

}
