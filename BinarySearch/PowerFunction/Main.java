package com.company;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        // System.out.println(m.pow(-1, 1, 20));
        // System.out.println(m.pow(0, 0, 20));
        System.out.println(m.pow(71045970, 41535484, 64735492));
    }

    public int pow(int x, int n, int d) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        if ((n % 2) == 0) {
            long y = pow(x, n / 2, d);
            long z = Math.floorMod(y, d);

            z = z * z;

            return Math.floorMod(z, d);
        }

        long y = pow(x, n - 1, d);
        return Math.floorMod(Math.floorMod(x, d) * Math.floorMod(y, d), d);
    }
}
