package Level_1.LongestIncreasingSubsequence.LIS_Variations;

import java.util.Arrays;

public class MaximumLengthofPairChain_Tabulation {

    public static int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;
        for(int i =1;i<n;i++)
        {
            int max = dp[i];
            for(int j = 0;j<i;j++)
            {
                if(pairs[j][1] < pairs[i][0])
                {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8},{4,5}};
        int longestChain = findLongestChain(pairs);
        System.out.println(longestChain);
    }
}
