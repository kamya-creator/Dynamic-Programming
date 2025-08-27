package Level_1.UnboundedKnapsack.Coin_Change_Count_Ways;

public class Coin_Change_Count_Ways_Recurssion {
    public static int solve(int index, int[] coins, int sum)
    {
        if(index >= coins.length || sum <= 0)
        {
            if(sum == 0) return 1;
            return 0;
        }
        int take = solve(index , coins, sum - coins[index]);
        int skip = solve(index + 1, coins, sum);

        return take + skip;
    }
    public static int count(int coins[], int sum) {
        // code here.
        int ans = 0;
        ans = solve(0, coins, sum);
        return ans;
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        int ans = count(coins, sum);
        System.out.println(ans);
    }
}
