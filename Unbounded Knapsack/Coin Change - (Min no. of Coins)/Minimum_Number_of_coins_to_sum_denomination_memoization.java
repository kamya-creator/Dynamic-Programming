package Level_1.UnboundedKnapsack.Coin_Change_Min_no_of_coins;

import java.util.Arrays;

public class Minimum_Number_of_coins_to_sum_denomination_memoization {
    static int[][] dp;
    public  static int solve(int index, int[] coins, int sum)
    {
        if(index >= coins.length || sum <= 0)
        {
            if(sum == 0) return 0;
            return Integer.MAX_VALUE - 1;
        }
        if(dp[index][sum] != -1) return dp[index][sum];
        int take = 1 + solve(index, coins, sum - coins[index]);
        int skip = solve(index + 1, coins, sum);
        return dp[index][sum] = Math.min(take, skip);
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i = 0;i<=n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(0, coins, amount) ;
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}
