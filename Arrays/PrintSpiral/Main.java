package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= 4; j++) {
                temp.add(j);
            }
            matrix.add(temp);
        }
        Main m = new Main();
        System.out.println(matrix);
        ArrayList<Integer> inline = m.spiralOrder(matrix);
        System.out.println(inline);
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        Integer m = A.size();
        ArrayList<Integer> inlineArray = new ArrayList<>();

        if (m > 0){
            Integer n = A.get(0).size();

            Integer L = 0;
            Integer R = n - 1;
            Integer T = 0;
            Integer B = m - 1;

            Integer dir = 0;

            while (L <= R && T <= B) {
                if (dir == 0) {

                    for (int i = L; i <= R; i++) {
                        inlineArray.add(A.get(T).get(i));
                    }

                    T++;
                    dir = 1;
                } else if (dir == 1) {
                    for (int i = T; i <= B; i++) {
                        inlineArray.add(A.get(i).get(R));
                    }

                    R--;
                    dir = 2;
                } else if (dir == 2) {

                    for (int i = R; i >= L; i--) {
                        inlineArray.add(A.get(B).get(i));
                    }

                    B--;
                    dir = 3;
                } else if (dir == 3) {

                    for (int i = B; i >= T; i--) {
                        inlineArray.add(A.get(i).get(L));
                    }

                    L++;
                    dir = 0;
                }
            }

        }
        return inlineArray;

    }
}
