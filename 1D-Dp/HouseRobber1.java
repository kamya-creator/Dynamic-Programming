package Level_1._1D_Based_DP;

public class HouseRobber1 {
    static int[] dp;
    public static int solve(int index, int[] arr)
    {
        if(index >= arr.length) return 0;

        int take = arr[index] + solve(index + 2, arr);
        int skip = solve(index + 1, arr);

        return Math.max(take, skip);
    }
    public static int solve2(int index, int[] arr)
    {
        if(index >= arr.length) return 0;

        if(dp[index] != 0 ) return dp[index];
        int take = arr[index] + solve(index + 2, arr);
        int skip = solve(index + 1, arr);

        return dp[index] = Math.max(take, skip);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i<=n;i++)
        {
            dp[i] = Math.max(nums[i-1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        dp = new int[arr.length + 1];
        solve(0, arr);
        solve2(0, arr);

        int rob = rob(arr);
        System.out.println(rob);
    }
}
