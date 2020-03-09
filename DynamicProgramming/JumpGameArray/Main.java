package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        ArrayList<Integer> jumpAl = new ArrayList<>();
        jumpAl.add(3);
        jumpAl.add(2);
        jumpAl.add(1);
        jumpAl.add(0);
        jumpAl.add(4);
        System.out.println(m.canJump(jumpAl));
    }

    public int canJump(ArrayList<Integer> A) {
        int curJump = 0;

        for(int i = 0; i < A.size(); i++){
            if(curJump < 0) return 0;
            curJump = Math.max(A.get(i), curJump);
            curJump--;
        }
        return 1;
    }

    /**
     * Recursive Solution

    public int canJump(ArrayList<Integer> A) {
        if(canJumpHelper(A, 0, A.size() - 1)){
            return 1;
        }
        return 0;
    }

    public boolean canJumpHelper(ArrayList<Integer> A, int curIdx, int endIdx){
        if(curIdx >= endIdx){
            return true;
        }

        int maxJumps = A.get(curIdx);
        for(int numJump = 1; numJump <= maxJumps; numJump++){

            if(canJumpHelper(A, curIdx + numJump, endIdx)){
                return true;
            }
        }

        return false;
    }
     */
}
