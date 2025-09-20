package Level_2.Cataln;

public class CatalanNumber_Memoization {
    static int[] dp;
    public static int solve(int n)
    {
        if( n == 0 || n == 1)
        {
            return 1;
        }
        if(dp[n] != 0) return dp[n];
        int ans  = 0;
        for(int k = 1; k<=n ;k++)
        {
            ans+= solve(k - 1) * solve( n - k);
        }
        return dp[n] = ans;
    }
    public static int findCatalan(int n) {
        // code here
        return solve(n);
    }
    public static void main(String[] args) {
        int n = 19;
        dp = new int[n + 1];
        dp[1] = dp[0] = 1;
        int solve = solve(n);
        System.out.println(solve);


    }
}
