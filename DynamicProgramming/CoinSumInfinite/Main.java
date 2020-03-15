import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);

        System.out.println(m.coinchange2(coins, 5));
    }

    public int coinchange2(ArrayList<Integer> A, int B) {

        int[] dp = new int[B + 1];

        dp[0] = 1;

        for(int i = 1; i < A.size() + 1; i++){
            for(int j = 1; j < B + 1; j++){

                if((j - A.get(i - 1)) >= 0){
                    dp[j] += dp[j - A.get(i - 1)];
                    dp[j] = dp[j] % 1000007;
                }
            }
        }
        return dp[B];
    }

    // Recursive Solution
    // public int coinchange2(ArrayList<Integer> A, int B) {
    //
    //     return coinchangeHelper(A, B, A.size() - 1);
    // }
    //
    // public int coinchangeHelper(ArrayList<Integer> A, int B, int idx) {
    //     if(B < 0 || idx < 0)
    //         return 0;
    //     if(B == 0)
    //         return 1;
    //
    //     return coinchangeHelper(A, B - A.get(idx), idx) + coinchangeHelper(A, B, idx - 1);
    // }
}
