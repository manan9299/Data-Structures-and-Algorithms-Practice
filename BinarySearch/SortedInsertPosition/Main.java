package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);

        Main m = new Main();
        System.out.println(m.searchInsert(nums, -1));
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        int insertIdx = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = a.get(mid);

            if(b <= cur){
                insertIdx = mid;
                high = mid - 1;
            } else {
                insertIdx = mid + 1;
                low = mid + 1;
            }
        }

        return insertIdx;
    }
}
