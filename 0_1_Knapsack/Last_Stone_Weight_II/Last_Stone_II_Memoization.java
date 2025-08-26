package Level_1.Knapsack.Last_Stone_2;

import java.util.Arrays;

public class Last_Stone_II_Memoization {
    static int total;
    static int[][] dp;
    public static int solve(int index, int[] arr, int ssf, int W)
    {
        if(index >= arr.length)
        {
            return Math.abs(ssf - (total - ssf));
        }
        if(dp[index][ssf] != -1) return dp[index][ssf];
        int take = solve(index + 1, arr, ssf + arr[index], W);
        int skip = solve(index + 1, arr, ssf, W);
        return dp[index][ssf] = Math.min(take, skip);

    }
    public static int lastStoneWeightII(int[] stones) {

        for(int i : stones) total+=i;
        int n = stones.length;
        dp= new int[n+1][total+1];
        for(int i =0;i<=n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, stones, 0, total);
    }

    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        int ans = lastStoneWeightII(stones);
        System.out.println(ans);
    }
}
