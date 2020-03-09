package com.company;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        int[] bars = {1, 5, 4, 3};
        System.out.println(m.maxArea(bars));
    }

    public int maxArea(int[] A) {
        if(A.length < 2) return 0;

        int maxVol = 0;

        int left = 0;
        int right = A.length - 1;

        while (left < right) {

            int leftHeight = A[left];
            int rightHeight = A[right];

            int curVol = (right - left) * Math.min(leftHeight, rightHeight);
            maxVol = Math.max(maxVol, curVol);

            if(leftHeight <= rightHeight)
                left++;
            else
                right--;
        }

        return maxVol;
    }

}
