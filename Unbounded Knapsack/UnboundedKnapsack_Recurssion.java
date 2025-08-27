package Level_1.UnboundedKnapsack;

public class UnboundedKnapsack_Recurssion {
    static int solve(int[] val, int[] wt, int index, int W)
    {
        if(index < 0 || W == 0)
        {
                return 0 ;
        }
        if(W >= wt[index])
        {
            int take = val[index] + solve(val, wt, index, W - wt[index]);
            int skip = solve(val, wt, index - 1, W);
            return Math.max(take, skip);
        }
        else{
            int skip = solve(val, wt, index - 1, W);
            return skip;

        }

    }
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        return solve(val, wt, n - 1, capacity);
    }

    public static void main(String[] args) {
        int[] val = {1, 1}, wt = {2, 1}; int capacity = 3;
        System.out.println(knapSack(val,wt,capacity));
    }
}
