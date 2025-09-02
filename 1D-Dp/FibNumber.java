package Level_1._1D_Based_DP;

public class FibNumber {
    static int[] dp ;
    public static int fibRecurssion(int n)
    {
        if(n ==0 || n ==1) return n;
        return fibRecurssion(n-1) + fibRecurssion(n-2);
    }

    public static int fibMemoization(int n)
    {
        if(n == 0 || n == 1) return n;
        if(dp[n] != 0) return dp[n];

        return dp[n] = fibMemoization(n-1) + fibMemoization(n-2);
    }
    public static int fibBottomUp(int n)
    {
        int[] dp = new int[n  + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i =2;i<=n;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int oonstant(int n)
    {

        if(n <= 1) return n;
        int a =0, b= 1; int c=0;
        for(int i =2;i<=n;i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return c;

    }
    public static void main(String[] args) {

        int n =30;
        int ans = fibRecurssion(n);
        System.out.println(ans);

        dp = new int[n+1];
        ans = fibMemoization(n);
        System.out.println(ans);

        ans = fibBottomUp(n);
        System.out.println(ans);

        ans = oonstant(n);
        System.out.println(ans);

    }
}
