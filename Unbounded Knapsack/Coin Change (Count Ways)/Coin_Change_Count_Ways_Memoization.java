package Level_1.UnboundedKnapsack.Coin_Change_Count_Ways;

import java.util.Arrays;

public class Coin_Change_Count_Ways_Memoization {
    static int[][] dp;
    public static int solve(int index, int[] coins, int sum)
    {
        if(index >= coins.length || sum <= 0)
        {
            if(sum == 0) return 1;
            return 0;
        }
        if(dp[index][sum] != -1) return dp[index][sum] ;
        int take = solve(index , coins, sum - coins[index]);
        int skip = solve(index + 1, coins, sum);

        return dp[index][sum] = take + skip;
    }
    public static int count(int coins[], int sum) {
        // code here.
        int ans = 0;
        ans = solve(0, coins, sum);
        return ans;
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int n = coins.length;
        int sum = 10;
        dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = count(coins, sum);
        System.out.println(ans);
    }
}
