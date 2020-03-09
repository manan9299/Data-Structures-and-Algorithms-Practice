package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        
        test.add(15);
        test.add(20);
        test.add(12);
        test.add(19);
        test.add(4);

        Main m = new Main();

        System.out.println(m.subsets(test));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Collections.sort(A);
        output.add(new ArrayList<>());
        subsetHelper(A, 0, new ArrayList<>(), output);
        return output;
    }

    public void subsetHelper(ArrayList<Integer> A, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> output){
        for(int i = index; i < A.size(); i++){
            // System.out.println("Adding ==> " + A.get(i));
            temp.add(A.get(i));
            ArrayList<Integer> sortedTemp = new ArrayList<>(temp);
            output.add(new ArrayList<>(sortedTemp));
            subsetHelper(A, i + 1, temp, output);
            // System.out.println("Removing ==> " + temp.get(temp.size() - 1));
            temp.remove(temp.size() - 1);
        }
    }
}
