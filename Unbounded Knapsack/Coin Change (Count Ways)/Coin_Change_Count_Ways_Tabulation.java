package Level_1.UnboundedKnapsack.Coin_Change_Count_Ways;

import java.util.Arrays;

public class Coin_Change_Count_Ways_Tabulation {

    public static int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        for(int i =0;i<=sum;i++)
        {
            dp[0][i] = 0;
        }
        for(int i =0 ;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=sum;j++)
            {
                if(j >= coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i -1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int n = coins.length;
        int sum = 10;

        int ans = count(coins, sum);
        System.out.println(ans);
    }
}
