package Level_1.UnboundedKnapsack.RodCutting;

import java.util.Arrays;

public class RodCuttingMemoized {
    static int[][] dp;
    public static int solve(int index, int[] price, int[] arr, int W)
    {
        if(index >= price.length)
        {
            return 0;
        }
        if( dp[index][W] != -1)return  dp[index][W] ;
        if(W >= arr[index])
        {
            int take = price[index] + solve(index, price,arr, W - arr[index]);
            int skip = solve(index + 1, price,arr, W);
            return dp[index][W] = Math.max(take, skip);
        }
        else{
            return  dp[index][W] = solve(index + 1, price,arr, W);
        }
    }
    public static int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[] arr = new int[price.length];
        dp = new int[n + 1][n + 1];
        for(int i = 0;i<=n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < price.length; i++) {
            arr[i] = i +1;
        }
        return solve(0, price , arr, n);
    }

    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}
