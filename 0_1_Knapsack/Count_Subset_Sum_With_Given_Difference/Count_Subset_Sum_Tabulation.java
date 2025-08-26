package Level_1.Knapsack.Count_Subset_Sum_With_Given_Difference;

import java.util.Arrays;

public class Count_Subset_Sum_Tabulation {
    public static int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n + 1][target  + 1];

        for(int i =0;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        for(int i =1;i<=n;i++)
        {

            for(int j =0;j<=target;j++)
            {
                if(j >= nums[i - 1])
                {
                    dp[i][j] = dp[i - 1][j] + dp[i-1][j - nums[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][target];
    }
    public  static void main(String[] args) {
        /*

24
         */
        int[] arr = { 28 ,4 ,3 ,27, 0 ,24 ,26};
        int sum = 24;
        int perfected = perfectSum(arr, sum);
        System.out.println(perfected);

    }

}
