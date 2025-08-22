package Level_1.Knapsack.SubsetSum;

public class SubsetSum_Memoization {
    static Boolean solve(int index, int[] arr, int W , Boolean[][] dp)
    {
        if(W == 0) return true;
        if(index < 0 || W < 0) return false;

        if(dp[index][W] != null) return dp[index][W];
        Boolean take = solve(index - 1, arr, W - arr[index], dp);
        Boolean skip = solve(index - 1, arr, W, dp);

        return dp[index][W] = take || skip;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        return solve(n-1, arr, sum , dp);

    }
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int W = 11;
        boolean ans = isSubsetSum(arr,  W);
        System.out.println(ans);

    }
}
