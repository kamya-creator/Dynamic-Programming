package Level_1.LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence_Tabulation {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int ans =1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i =1;i<n;i++)
        {
            int max = dp[i];
            for(int j =0;j<i;j++)
            {
                if(arr[j] < arr[i])
                    max = Math.max(max, 1 + dp[j]);
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
