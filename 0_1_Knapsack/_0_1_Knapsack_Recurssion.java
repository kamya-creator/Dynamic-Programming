package Level_1.Knapsack;

public class _0_1_Knapsack_Recurssion {
    public static int solve(int index, int[] wt, int[] val, int W)
    {
        if(index >= wt.length) return 0;
        if( W >= wt[index])
        {
            int take = val[index] + solve(index + 1, wt, val, W - wt[index]);
            int skip = solve(index + 1, wt, val, W);
            return Math.max(take, skip);
        }
        else{
            return  solve(index + 1, wt, val, W);
        }
    }
    public static void main(String[] args) {
        int[] wt = { 2,1,3,1,4,1,2,2,5,7};
        int[] val = {6,3,8,6,9,8,2,4,10,9};
        int W = 4;
        int maxProfit = solve(0, wt, val, W);
        System.out.println(maxProfit);
    }
}
