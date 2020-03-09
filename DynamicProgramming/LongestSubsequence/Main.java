package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(17);
        nums.add(4);
        nums.add(12);
        nums.add(5);
        nums.add(6);
        nums.add(21);

        System.out.println(m.longestSubsequenceLength(nums));
        int[] lis = m.lis(nums);
        int[] lds = m.lds(nums);

        // Print LIS
        for(int i = 0; i < lis.length; i++){
            System.out.print(lis[i]);
        }
        System.out.println();

        // Print LDS
        for(int i = 0; i < lis.length; i++){
            System.out.print(lds[i]);
        }
        System.out.println();

        // Get Longest Subsequence
        System.out.println(m.getLongestSubsequence(lis, lds));
    }

    public int getLongestSubsequence(int[] lis, int[] lds){
        int n = lis.length;
        int max = 0;
    
        for(int i = 0; i < n; i++){
            int curSubseqLen = lis[i] + lds[i] - 1;
            if(curSubseqLen > max){
                max = curSubseqLen;
            }
        }
    
        return max;
    }

    public int[] lds(List<Integer> nums) {
        int numsLen = nums.size();
    
        int[] ldsIdx = new int[numsLen];
        Arrays.fill(ldsIdx, 1);
    
        for(int i = numsLen - 1; i >= 0; i--){
            for(int j = i + 1; j < numsLen; j++){
                if(nums.get(j) < nums.get(i)){
                    ldsIdx[i] = Math.max(ldsIdx[i], ldsIdx[j] + 1);
                }
            }
        }
    
        return ldsIdx;
    }
    
    public int[] lis(List<Integer> nums) {
        int numsLen = nums.size();
        int[] lisIdx = new int[numsLen];
        Arrays.fill(lisIdx, 1);
    
        for (int i = 0; i < numsLen; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) < nums.get(i)) {
                    lisIdx[i] = Math.max(lisIdx[i], lisIdx[j] + 1);
                }
            }
        }
    
        return lisIdx;
    }
}
