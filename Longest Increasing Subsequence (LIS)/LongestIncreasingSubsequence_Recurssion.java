package Level_1.LongestIncreasingSubsequence;

public class LongestIncreasingSubsequence_Recurssion {

    static int solve_rec(int index, int[] arr, int prev)
    {
        if(index >= arr.length) return 0;

        int skip = solve(index + 1, arr, prev);
        int take = 0;
        if(prev < arr[index])
        {
            take = 1 + solve(index + 1, arr, arr[index]);
        }
        return Math.max(skip, take);
    }


    static int solve(int index, int[] arr, int prev)
    {
        if(index >= arr.length) return 0;

        int skip = solve(index + 1, arr, prev);
        int take = 0;
        if(prev == -1 || arr[prev] < arr[index])
        {
            take = 1 + solve(index + 1, arr, index);
        }
        return Math.max(skip, take);
    }
    static int lis(int arr[]) {
        // code here
        return solve(0, arr, -1);
    }
}
