package Level_1.Knapsack.Count_Subset_Sum_With_Given_Difference;

public class Count_Subset_Sum_Recursion {
    public static int solve(int index, int[] nums, int W)
    {
        if(W < 0) return 0;
        if(index < 0)
        {
            return W==0 ? 1 : 0;
        }
        int take = solve(index - 1 , nums, W - nums[index]);
        int skip = solve(index - 1, nums, W);
        return take + skip;
    }
    public static int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        return solve(n - 1, nums, target);

    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        int W = 4;
        int ans = perfectSum(arr,  W);
        System.out.println(ans);

    }
}
