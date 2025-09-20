package Level_2.Cataln;

import java.util.Arrays;

public class NonIntersectingChordsInaCircle {
    public static int solve(int n)
    {
        if(n == 0 || n == 1)
            return 1;

        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans+= solve(i)*solve(n -i-1);
        }
        return ans;
    }
    static int[] dp = new int[15];
    public static int solve_dp(int n)
    {
        if(n == 0 || n == 1)
            return 1;

        if(dp[n] != 0 )return dp[n];
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans+= solve(i)*solve(n -i-1);
        }
        return dp[n] = ans;
    }
    public static int solve_tabulation(int n)
    {
        int[] t = new int[n + 1];
        t[0] = t[1] = 1;
        for (int i = 2;i<=n;i++)
        {
            for (int j = 0; j < i; j++) {
                t[i] = t[i] + t[j]*t[i - j - 1];

            }
        }
        System.out.println(Arrays.toString(t));
        return t[n];
    }

    public static void main(String[] args) {
        int N = 8;
        int ans  = solve(N/2);
        System.out.println(ans);

        int ans_dp = solve_dp(14);
        System.out.println(ans_dp);


        int tabulation = solve_tabulation(N / 2);
        System.out.println(tabulation);

    }
}
