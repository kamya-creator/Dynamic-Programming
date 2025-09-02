package Level_1.LCS.PrintLongestCommonSubsequence;


class PrintLCS {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static int n ;
    static int m ;
    static int lcs(String s1, String s2) {
        // code here
        n = s1.length();
        m = s2.length();
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

        print(n, m ,s1, s2, sb);

        return dp[n][m];
    }
    public static void print(int i, int  j, String s1, String s2, StringBuilder ssf)
    {

        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j - 1])
            {
                sb.append(s1.charAt(i-1));
                i--;
            }
            else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while(i > 0)
        {
            sb.append(s1.charAt(i-1));
            i--;
        }

        while(j > 0)
        {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        sb.reverse();
    }
    public static String allLCS(String s1, String s2) {
        // Code here
        lcs(s1, s2);
        return sb.toString();
    }

    public static void main(String[] args) {

        String s1 = "abaaa", s2 = "baabaca";
        String lcs = allLCS(s1, s2);
        System.out.println(lcs);
    }
}
