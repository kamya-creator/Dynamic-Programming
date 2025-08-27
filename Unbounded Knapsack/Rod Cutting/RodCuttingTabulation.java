package Level_1.UnboundedKnapsack.RodCutting;

import java.util.Arrays;

public class RodCuttingTabulation {
    static int[][] dp;

    public static int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[] arr = new int[price.length];
        dp = new int[n + 1][n + 1];

        for (int i = 0; i < price.length; i++) {
            arr[i] = i +1;
        }
        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=n;i++)
        {
            dp[0][i] = 0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j >= arr[i - 1])
                {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i-1] + dp[i][j - arr[i - 1]]);

                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][n];
    }


    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}
