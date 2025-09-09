package Level_1;

import java.util.ArrayList;

public class MaximumAlternatingSubsequenceSum {

    // better approach
    static int solve(int index, int[] nums, char sysm)
    {
        if(index >= nums.length)
        {
            return 0;
        }
        // skip
        int skip = solve(index + 1, nums, sysm);
        int take = 0;
        if(sysm == '+')
        {
            take = solve(index + 1, nums, '-') + nums[index];
        }
        else{
            take = solve(index + 1, nums, '+') - nums[index];
        }
        return Math.max(skip, take);
    }
    // Brute force
    static long max = Long.MIN_VALUE;
    public static void solve(int index, int[] nums, ArrayList<Integer> ssf)
    {
        if(index >= nums.length)
        {   int sum = 0;
            for(int i =0;i<ssf.size();i++)
            {
                if(i%2 == 0)
                {
                    sum+=ssf.get(i);
                }
                else{
                    sum-=ssf.get(i);
                }
            }
            max = Math.max(sum, max);
            return;
        }

        // skip
        solve(index + 1, nums, ssf);
        ssf.add(nums[index]);
        solve(index + 1, nums, ssf);
        ssf.remove(ssf.size() - 1);
    }
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        solve(0, nums, new ArrayList<>());
        return max;
    }
    public static void main(String[] args) {

        int[] nums = {6,2,1,2,4,5};
        // Brute Force approach
        long maxAlternatingSum = maxAlternatingSum(nums);
        System.out.println(maxAlternatingSum);

        // Better Approach
        int solve = solve(0, nums, '+');
        System.out.println(solve);
    }
}
