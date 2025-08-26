package Level_1.Knapsack.Count_Subset_Sum_With_Given_Difference;

import java.util.Arrays;

public class Count_Subset_Sum_Memoization {
     static int[][] dp;
    public static int solve(int index, int[] nums, int W)
    {
        if(W < 0) return 0;
        if(index < 0)
        {
            return W==0 ? 1 : 0;
        }
        if(dp[index][W] != -1)return dp[index][W];
        int take = solve(index - 1 , nums, W - nums[index]);
        int skip = solve(index - 1, nums, W);
        return dp[index][W] = take + skip;
    }
    public static int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        return solve(n - 1, nums, target);

    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        int W = 4;
        int n = arr.length;
        dp = new int[n+1][W +1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = perfectSum(arr,  W);
        System.out.println(ans);

    }
}
