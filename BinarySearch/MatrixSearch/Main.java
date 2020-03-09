package com.company;

public class Main {

    public static void main(String[] args) {

        int[][] A = {
                {22, 32, 67}
        };

        Main m = new Main();

        System.out.println(m.findFirstOccurance(A, 25));
        System.out.println(m.findLastOccurance(A, 25));
        System.out.println(m.findInsertionIdx(a, 2));

        System.out.println(m.searchMatrix(A, 82));
    }

    public int searchMatrix(int[][] A, int B) {

        int searchRowIdx = getRowIdx(A, B);

        if(searchRowIdx == -1) return 1;
        if(searchRowIdx >= A.length) return 0;

        return (binarySearch(A[searchRowIdx], B)) ? 1 : 0;
    }

    public boolean binarySearch(int[] A, int B){

        int low = 0;
        int high = A.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            int cur = A[mid];
            if(B == cur){
                return true;
            } else if(B > cur) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public int getRowIdx(int[][] A, int B){
        int numRows = A.length;
        int numCols = A[0].length;

        int top = 0;
        int bottom = numRows - 1;

        while(top <= bottom){
            int mid = (top + bottom) / 2;
            int cur = A[mid][numCols - 1];

            if(B == cur){
                return -1;
            } else if(B < cur){
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        return Math.min(top, bottom) + 1;
    }

    public int findInsertionIdx(int[] a, int n) {

        int low = 0;
        int high = a.length - 1;
        int insertionIdx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = a[mid];
            if (cur == n) {
                insertionIdx = mid;
                high = mid - 1;
            } else if (n < cur) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return insertionIdx != -1 ? insertionIdx : Math.min(low, high) + 1;
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

    // public int binarySearch(int[] a, int n) {
    //
    //     int low = 0;
    //     int high = a.length - 1;
    //
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         int cur = a[mid];
    //         if (cur == n) {
    //             return mid;
    //         } else if (n < cur) {
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //
    //     return -1;
    // }
}
