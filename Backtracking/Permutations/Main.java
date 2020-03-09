package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        Main m = new Main();
        ArrayList<ArrayList<Integer>> result = m.permute(al);
        System.out.println(result.size());
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        boolean[] visited = new boolean[A.size()];
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

        permuteHelper(A, visited, new ArrayList<>(), permutations);

        return permutations;
    }

    public void permuteHelper(ArrayList<Integer> A, boolean[] visited, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> output){

        if(temp.size() == A.size()){
            output.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < A.size(); i++){
            if(!visited[i]){
                temp.add(A.get(i));
                visited[i] = true;
                permuteHelper(A, visited, temp, output);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
