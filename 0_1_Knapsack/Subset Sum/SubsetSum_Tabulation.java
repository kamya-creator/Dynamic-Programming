package Level_1.Knapsack.SubsetSum;

public class SubsetSum_Tabulation {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n  + 1][sum +1];
        int W = sum;
        for(int i = 0 ; i<=W;i++)
        {
            dp[0][i] = false;
        }
        for(int i = 0;i<=n ;i++)
        {
            dp[i][0] = true;
        }
        for(int i = 1;i<= n; i++)
        {
            for(int j = 1; j<=W ;j++)
            {
                if(j >= arr[i - 1])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum] ;
    }
    public static void main(String[] args) {

        int[] arr = {34, 37 ,47 ,38 ,5 ,16, 3 ,25};
        int W = 119;
        boolean ans = isSubsetSum(arr,  W);
        System.out.println(ans);

    }
}
