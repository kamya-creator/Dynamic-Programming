package Level_1.Knapsack.TargetSum;

import java.util.Arrays;

public class TargetSum_Tabulation {
    static int[][] dp;

    public static int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int range = 0;
        for(int i : arr) range+=i;
        if(target > range) return 0;

        if((range - target)%2 != 0) return 0;
        int W = (range - target)/2;

        dp = new int[n + 1][W + 1];

        for (int i = 0;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=W ; j++) {
                if(j>=arr[i - 1])
                {               // exclude   // include
                    dp[i][j] = dp[i -1][j] + dp[i - 1][j - arr[i -1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];

    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1}; int target = 3;
        int targetSumWays = findTargetSumWays(arr, target);
        System.out.println(targetSumWays);
    }
}
