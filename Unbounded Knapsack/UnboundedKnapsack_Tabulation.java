package Level_1.UnboundedKnapsack;

import java.util.Arrays;

public class UnboundedKnapsack_Tabulation {
    static int[][] dp;

    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        dp = new int[n + 1][capacity + 1];
        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=capacity;i++)
        {
            dp[0][i] = 0;
        }
        for(int i = 1;i<=n;i++)
        {
            for(int j =1;j<=capacity;j++)
            {
                if( j >= wt[i - 1])
                {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j- wt[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] val = {6, 1, 7, 7}, wt = {1, 3, 4, 5}; int capacity = 8;
        int n = wt.length;
        dp = new int[n + 1][capacity + 1];

        System.out.println(knapSack(val,wt,capacity));
    }
}
