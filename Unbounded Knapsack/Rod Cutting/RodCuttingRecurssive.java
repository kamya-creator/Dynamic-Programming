package Level_1.UnboundedKnapsack.RodCutting;

public class RodCuttingRecurssive {
    public  static int solve(int index, int[] price,int[] arr, int W)
    {
        if(index >= arr.length)
        {
            return 0;
        }

        if(W >= arr[index])
        {
            int take = price[index] + solve(index, price, arr,W - arr[index]);
            int skip = solve(index + 1, price,arr, W);
            return Math.max(take, skip);
        }
        else{
            return solve(index + 1, price, arr, W);
        }
    }
    public  static int cutRod(int[] price, int[] arr) {
        // code here
        int n = price.length;
        return solve(0, price, arr,n);
    }
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] arr = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            arr[i] = i +1;
        }
        System.out.println(cutRod(price, arr));
    }
}
