package Level_1._1D_Based_DP;

public class ClimbingStairs {
    static int[] dp = new int[46];
    public static int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != 0) return dp[n];
        return dp[n] = climbStairs(n-1) + climbStairs(n-2);
    }
    public static int climbStairs_tabulation(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++)
        {
            dp[i] = dp[Math.max(i-1, 0)] + dp[Math.max(i-2, 0)];
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int climbedStairs = climbStairs(n);
        System.out.println(climbedStairs);

        int climbed = climbStairs_tabulation(n);
        System.out.println(climbed);
    }
}
