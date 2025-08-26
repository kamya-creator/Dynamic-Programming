package Level_1.Knapsack.Last_Stone_2;

public class Last_Stone_II_Tabulation {
    static int total;
    static boolean[][] dp;

    public static int lastStoneWeightII(int[] stones) {

        for(int i : stones) total+=i;
        int n = stones.length;
        dp= new boolean[n+1][total+1];
        for(int i =0;i<=n;i++)
        {
            dp[i][0] = true;
        }
        for(int i = 1;i<=n;i++)
        {
            for(int j =1;j<=total;j++)
            {
                if(j >= stones[i -1])
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<=total;i++)
        {
            if(dp[n][i] == true)
            {
                ans  = Math.min(ans, Math.abs(total - 2*i));
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        int ans = lastStoneWeightII(stones);
        System.out.println(ans);
    }
}
