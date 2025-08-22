package Level_1.Knapsack.EqualPartionSum;

public class Equal_Partition_Tabulation {
    static Boolean[][] dp;


    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        int sum = 0 ;
        for(int a : arr)
        {
            sum+=a;
        }
        if(sum% 2 != 0) System.out.println(false);
        int W = sum/2;
        dp = new Boolean[n + 1][W  + 1];

        for (int i = 0; i <= W; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= W ; j++) {
                if(j >= arr[i - 1])
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        System.out.println(dp[n][W]);

    }
}
