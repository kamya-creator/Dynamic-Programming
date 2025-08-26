package Level_1.Knapsack.MinimumSubsetSum_Difference;

import java.util.Arrays;

public class Minimum_sum_partition_Tabulation {

    public static int minDifference(int arr[]) {
        int range = 0;
        for(int a :arr) range+=a;
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][range + 1];
        for (int i = 0; i <= range ; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = true;
        }
//        for (int i = 0; i <=n ; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= range ; j++) {
                if(j >= arr[i - 1])
                {
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j - arr[i - 1]];
                }
                else{
                    System.out.println(i+" " +j + " ----- " + arr[i - 1]);
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        int ans  =Integer.MAX_VALUE ;
        for (int i = 1; i <= range ; i++) {
            if(dp[n][i] == true)
                ans = Math.min(ans , Math.abs(range - 2*i));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { 9,2,2,3};
        //int[] arr = { 1};
        int minDifference = minDifference(arr);
        System.out.println(minDifference);
    }
}
