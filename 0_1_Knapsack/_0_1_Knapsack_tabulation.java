package Level_1.Knapsack;

import java.util.Arrays;

public class _0_1_Knapsack_tabulation {
    public static void main(String[] args) {
        int[] wt = {2, 1, 3, 1, 4, 1, 2, 2, 5, 7};
        int[] val = {6, 3, 8, 6, 9, 8, 2, 4, 10, 9};
        int W = 4;
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}


