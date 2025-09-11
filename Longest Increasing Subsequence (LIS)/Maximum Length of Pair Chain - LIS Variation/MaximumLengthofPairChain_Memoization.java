package Level_1.LongestIncreasingSubsequence.LIS_Variations;

import java.util.Arrays;

public class MaximumLengthofPairChain_Memoization {
    static int[][] dp;
    public  static int solve(int index, int[][] pairs, int prev_index)
    {
        if(index >= pairs.length)
            return 0;

        if(prev_index != -1 && dp[index][prev_index] != -1)
            return dp[index][prev_index];

        int skip = solve(index + 1, pairs, prev_index);
        int take = 0;

        if(prev_index == -1 || pairs[prev_index][1] < pairs[index][0])
        {
            take = 1 + solve(index + 1, pairs, index);
        }
        if(prev_index != -1)
            return dp[index][prev_index] = Math.max(skip, take);

        return Math.max(skip, take);
    }
    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        dp = new int[n + 1][n + 1];
        for(int i =0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        return solve(0, pairs, -1);
    }
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8},{4,5}};
        int longestChain = findLongestChain(pairs);
        System.out.println(longestChain);
    }
}
