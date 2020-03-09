package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(2);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(3);
        al2.add(4);

        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(10);
        al3.add(11);
        al3.add(5);

        ArrayList<Integer> al4 = new ArrayList<>();
        al4.add(15);
        al4.add(14);
        al4.add(13);
        al4.add(12);

        al.add(al1);
        al.add(al2);
        al.add(al3);
        al.add(al4);

        Main m = new Main();
        System.out.println(m.minimumTotal(al));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 0) return 0;

        for(int i = a.size() - 2; i >=0; i--){
            for(int j = 0; j < a.get(i).size(); j++){
                a.get(i).set(j, a.get(i).get(j) + Math.min(a.get(i + 1).get(j), a.get(i + 1).get(j + 1)));
            }
        }

        return a.get(0).get(0);
    }

    // Recursive Solution
    // private int minPathSumHelper(ArrayList<ArrayList<Integer>> a, int level, int index, int curSum){
    //     if(level >= a.size()){
    //         return curSum;
    //     }
    //
    //     int left = a.get(level).get(index);
    //     int right = a.get(level).get(index + 1);
    //     int nextLevel = level + 1;
    //
    //     return Math.min(minPathSumHelper(a, nextLevel, index, curSum + left), minPathSumHelper(a, nextLevel, index + 1, curSum + right));
    // }
}
