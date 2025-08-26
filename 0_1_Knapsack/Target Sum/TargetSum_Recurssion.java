package Level_1.Knapsack.TargetSum;

import java.util.Arrays;

public class TargetSum_Recurssion {
    public static int solve(int index, int[] arr, int ssf, int W)
    {
        if(index>=arr.length)
        {
            if(ssf == W) return 1;
            else return 0;
        }
        int take = solve(index + 1, arr, ssf + arr[index], W);
        int skip = solve(index + 1, arr, ssf, W);
        return  take + skip;
    }
    public static int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int range = 0;
        for(int i : arr) range+=i;
        if(target > range) return 0;

        if((range - target)%2 != 0) return 0;
        int W = (range - target)/2;

        return solve(0, arr, 0, W);


    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1}; int target = 3;
        int targetSumWays = findTargetSumWays(arr, target);
        System.out.println(targetSumWays);
    }
}
