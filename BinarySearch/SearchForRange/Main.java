package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        Main m = new Main();
        int[] nums = {1, 2, 3, 3, 3, 5}
        int[] idx = searchRange(nums, 3);

        System.out.println(idx[0]);
        System.out.println(idx[1]);
    }

    public int[] searchRange(final int[] A, int B) {

        int[] startEndIdx = new int[2];

        int firstOccuranceIdx = findFirstOccurance(A, B);
        if(firstOccuranceIdx == -1) {
            Arrays.fill(startEndIdx, -1);
            return startEndIdx;
        }

        startEndIdx[0] = firstOccuranceIdx;
        startEndIdx[1] = findLastOccurance(A, B);

        return startEndIdx;
    }

    public int findFirstOccurance(int[] a, int n) {

        int low = 0;
        int high = a.length - 1;
        int firstOccurance = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = a[mid];
            if (cur == n) {
                firstOccurance = mid;
                high = mid - 1;
            } else if (n < cur) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return firstOccurance;
    }

    public int findLastOccurance(int[] a, int n) {

        int low = 0;
        int high = a.length - 1;
        int lastOccurance = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = a[mid];
            if (cur == n) {
                lastOccurance = mid;
                low = mid + 1;
            } else if (n < cur) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lastOccurance;
    }
}
