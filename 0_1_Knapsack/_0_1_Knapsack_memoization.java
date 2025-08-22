package Level_1.Knapsack;

import java.util.Arrays;

public class _0_1_Knapsack_memoization {
    static int[][] dp ;
    public static int solve(int index, int[] wt, int[] val, int W)
    {
        if(index >= wt.length) return 0;

        if(dp[index][W] != -1) return dp[index][W];
        if(W >= wt[index])
        {
            int take = val[index] + solve(index + 1, wt, val, W - wt[index]);
            int skip = solve(index + 1, wt, val, W);
            return dp[index][W] = Math.max(take, skip);
        }
        else{
            return dp[index][W]= solve(index + 1, wt, val, W);
        }

    }
    public static void main(String[] args) {
        int[] wt = { 2,1,3,1,4,1,2,2,5,7};
        int[] val = {6,3,8,6,9,8,2,4,10,9};
        int W = 4;
        int n = wt.length;
        dp = new int[n+1][W + 1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(dp[i] , -1);
        }
        int maxProfit = solve(0, wt, val, W);
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(maxProfit);
    }
}
