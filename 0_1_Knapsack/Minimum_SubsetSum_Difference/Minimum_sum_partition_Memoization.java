package Level_1.Knapsack.MinimumSubsetSum_Difference;

import java.util.Arrays;

public class Minimum_sum_partition_Memoization {
    static int[][] dp;
    public static int solve(int index, int[] arr, int ssf, int range)
    {
        if(index >= arr.length)
        {
            return Math.abs(range - 2 * ssf);
        }
        if(dp[index][ssf] != -1) return dp[index][ssf];
        int take = solve(index + 1, arr, ssf + arr[index], range);
        int skip = solve(index + 1, arr, ssf, range);

        return dp[index][ssf] = Math.min(take, skip);
    }
    public static int minDifference(int arr[]) {
        int range = 0;
        for(int a :arr) range+=a;
        int n = arr.length;
        dp = new int[n + 1][range + 1];
        for (int i = 0; i <=n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, arr, 0, range);

    }
    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5};
        //int[] arr = { 1};
        int minDifference = minDifference(arr);
        System.out.println(minDifference);
    }
}
