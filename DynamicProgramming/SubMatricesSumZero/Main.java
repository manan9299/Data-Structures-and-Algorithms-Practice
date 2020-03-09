package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> testAl = new ArrayList<>();

        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(-8);
        al1.add(5);
        al1.add(7);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(3);
        al2.add(7);
        al2.add(-8);

        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(5);
        al3.add(-8);
        al3.add(9);

        testAl.add(al1);
        testAl.add(al2);
        testAl.add(al3);

        Main m = new Main();
        System.out.println(m.solve(testAl));
    }

    //Consider all possible combinations of contiguous columns and keep on adding the column elements to a row matrix column by column
    //https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
    public int solve(ArrayList<ArrayList<Integer>> A) {

        int m = A.size();
        if(m == 0) return 0;

        int n = A.get(0).size();

        int subArrCount = 0;

        //Define left boundry of column
        for(int left = 0; left < n; left++){

            int[] colSum = new int[m];

            //Define right boundry of column
            for(int right = left; right < n; right++){

                //Once all the row elements for a column are added to the column array,
                //find the possible subarrays which sum up to target.
                //After that, keep adding next columns to target until we reach n;
                //Repeat the process for all left boundaries
                for(int rowIdx = 0; rowIdx < m; rowIdx++){
                    colSum[rowIdx] += A.get(rowIdx).get(right);
                }
                subArrCount += numSubArrayTargetSum(colSum, 0);
            }
        }

        return subArrCount;
    }

    //Explanation #4 https://leetcode.com/problems/subarray-sum-equals-k/solution/
    private int numSubArrayTargetSum(int[] arr, int target){

        HashMap<Integer, Integer> sumFreq = new HashMap<>();

        int curSum = 0;
        int subArrayCount = 0;

        //If the sum equals target at any point, we would not have that entry in the map
        //initialize map with 0,1
        sumFreq.put(0, 1);

        // The idea behind this approach is as follows: If the cumulative sum(repreesnted by sum[i]sum[i] for sum upto i^{th}i th index) upto two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum upto two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.
        for(int i = 0; i < arr.length; i++){
            curSum += arr[i];

            if(sumFreq.containsKey(curSum - target)){
                subArrayCount += sumFreq.get(curSum - target);
            }
            sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0) + 1);
        }

        return subArrayCount;
    }
}
