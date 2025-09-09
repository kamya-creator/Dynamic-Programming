package Level_1._1D_Based_DP;

import java.util.Arrays;

public class HouseRobber2 {
    static int[] dp;
    public static int solve(int index, int boundary, int[] nums)
    {
        if(index > boundary) return 0;
        if(dp[index] != -1) return dp[index];
        int take = nums[index] + solve(index + 2, boundary, nums);
        int skip = solve(index + 1, boundary, nums);

        return dp[index] = Math.max(take, skip);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int max = 0;
        int ans = solve(0, n - 2, nums);
        max = ans;
        Arrays.fill(dp, -1);
        ans = solve(1, n-1, nums);

        return Math.max(ans, max);


    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        rob(nums);
    }
}
