package Level_1.LCS.PrintLongestCommonSubsequence;

import java.util.Arrays;

public class LCS_Print_Tabulation {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    static int lcs(String s1, String s2) {
        // code here
        int n = s2.length();
        int m = s1.length();
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
                if(s2.charAt(i-1) == s1.charAt(j - 1))
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
        print(n, m ,s1, s2);
        return dp[n][m];
    }
    public static void print(int i, int  j, String s1, String s2)
    {
        if(i <= 0  || j <= 0 ) return;
        if((i >= 0 && j >= 0) && s2.charAt(i-1) == s1.charAt(j - 1))
        {
            sb.append(s2.charAt(i - 1));
            System.out.println(sb);

            print(i - 1, j - 1, s1, s2);
        }
        else{
            if(dp[i][j - 1] > dp[i-1][j])
            {
                print(i, j - 1, s1, s2);
            }
            else {
                print(i - 1, j, s1, s2);
            }
        }
    }
    public static void main(String[] args) {

        String s1 = "ABCDGH", s2 = "ABEDFHA";
        int ans = lcs(s1, s2);
        System.out.println(ans);
        System.out.println(sb.reverse().toString());
    }
}
