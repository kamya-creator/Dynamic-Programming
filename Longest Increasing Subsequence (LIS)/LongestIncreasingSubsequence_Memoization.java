package Level_1.LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence_Memoization {
    static int[][] dp = new int[1001][1001];
    static int solve(int index, int[] arr, int prev)
    {
        if(index >= arr.length) return 0;

        if(prev != -1 && dp[index][prev] != -1)
            return dp[index][prev] ;

        int skip = solve(index + 1, arr, prev);
        int take = 0;
        if(prev == -1 || arr[prev] < arr[index])
        {
            take = 1 + solve(index + 1, arr, index);
        }
        if(prev != -1)
            return dp[index][prev] = Math.max(skip, take);

        return Math.max(skip, take);
    }
    static int lis(int arr[]) {
        // code here
        for(int i =0;i<=1000;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, arr, -1);
    }

    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int lis = lis(arr);
        System.out.println(lis);
    }
}
