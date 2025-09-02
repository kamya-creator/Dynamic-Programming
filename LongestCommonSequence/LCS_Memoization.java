package Level_1.LCS;

import java.util.Arrays;

public class LCS_Memoization {
    static int[][] dp;
    static int solve(String s1, String s2, int n , int m)
    {
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m))
        {
             return dp[n][m]=  1 + solve(s1, s2, n - 1, m - 1);
        }
        else{

            int a = solve(s1,s2, n, m-1);
            int b = solve(s1, s2, n - 1, m);
            return  dp[n][m]  = Math.max(a,b);
        }
    }
    static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], -1);
        return solve(s1, s2, n-1, m - 1);
    }
    public static void main(String[] args) {

        String s1 = "ABCDGH", s2 = "AEDFHR";
        int ans = lcs(s1, s2);
        System.out.println(ans);
    }
}
