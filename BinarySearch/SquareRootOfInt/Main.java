package com.company;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.sqrt(2147483647));
    }

    public int sqrt(int A) {
        if(A == 0) return 0;

        long low = 1;
        long high = A;

        long root = 1;

        while(low <= high) {
            long mid = (low + high) / 2;
            long midSquare = mid * mid;

            if(midSquare == A){
                return (int)mid;
            } else if (midSquare < A){
                root = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)root;
    }

}
