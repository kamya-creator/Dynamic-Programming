package Level_1.UnboundedKnapsack.Coin_Change_Min_no_of_coins;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Minimum_Number_of_coins_to_sum_denomination_tabulation {
    static int[][] dp ;

    public  static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i = 0;i<=amount;i++)
        {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = 0;
        }

        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=amount;j++)
            {
                if(j >= coins[i-1])
                {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 +  dp[i][j - coins[i - 1]]);

                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        int ans = dp[n][amount] ;
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}
