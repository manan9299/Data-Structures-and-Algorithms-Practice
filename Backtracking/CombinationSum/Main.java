package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(8);
        al.add(10);
        al.add(8);
        
        System.out.println(m.combinationSum(al, 16));

    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();

        combinationSumHelper(A, B, 0, temp, res);

        return res;

    }

    public void combinationSumHelper(ArrayList<Integer> A, int B, int i, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> output){

        if(B == 0){
            // System.out.println("Output Updated=======");
            output.add(new ArrayList<>(curList));
            return;
        }
        if(B < 0){
            return;
        }

        for(int j = i; j < A.size(); j++){
            curList.add(A.get(j));
            // System.out.println(curList);
            combinationSumHelper(A, B - A.get(j), j, curList, output);
            curList.remove(curList.size() - 1);
            // System.out.println(curList);
        }
    }






    // public ArrayList<ArrayList<Integer>> combine(int A, int B) {
    //     ArrayList<ArrayList<Integer>> output = new ArrayList<>();
    //     combinationHelper(A, B, 1, new ArrayList<>(), output);
    //
    //     return output;
    // }
    //
    // public void combinationHelper(int N, int k, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> output){
    //     for(int i = index; i <= N; i++){
    //         temp.add(i);
    //         if(temp.size() == k){
    //             output.add(new ArrayList<>(temp));
    //         } else {
    //             combinationHelper(N, k, i + 1, temp, output);
    //         }
    //         temp.remove(temp.size() - 1);
    //     }
    // }
}
