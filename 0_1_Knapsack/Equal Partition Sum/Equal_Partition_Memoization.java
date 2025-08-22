package Level_1.Knapsack.EqualPartionSum;

public class Equal_Partition_Memoization {
    static Boolean[][] dp;
    static boolean solve(int index, int[] arr, int W)
    {
        if(W == 0) return true;
        if(index < 0 || W < 0) return false;
        if(dp[index][W] != null) return dp[index][W];

        boolean take = solve(index - 1, arr, W - arr[index]);
        boolean skip = solve(index - 1, arr, W);

        return dp[index][W] = take || skip;
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int sum = 0 ;
        for(int a : arr)
        {
            sum+=a;
        }
        if(sum% 2 != 0) return false;
        int W = sum/2;
        dp = new Boolean[n + 1][W  + 1];
        return solve(n - 1, arr, W);
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean partition = equalPartition(arr);
        System.out.println(partition);
    }
}
