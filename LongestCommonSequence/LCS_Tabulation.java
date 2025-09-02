package Level_1.LCS;

import java.util.Arrays;

public class LCS_Tabulation {
    static int[][] dp;

    static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <=m ; i++) {
                dp[0][i] = 0;
        }
        for(int i =1;i<=n;i++)
        {
            for(int j =1;j<=m;j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][m];
    }
    public static void main(String[] args) {

        String s1 = "ABCDGH", s2 = "ABEDFHA";
        int ans = lcs(s1, s2);
        System.out.println(ans);
    }
}
