package Level_1.Knapsack.SubsetSum;

public class SubsetSum_Recurssion {
    public static boolean solve(int index, int[] arr, int sum, int W)
    {
        if(sum == W) {
            System.out.println("Krishna");
            return true;
        }
        if(index >= arr.length) return false;

        return solve(index + 1, arr, sum + arr[index], W)
                || solve(index + 1, arr, sum, W);
    }
    public static void main(String[] args) {

        int[] arr = {34, 37 ,47 ,38 ,5 ,16, 3 ,25};
        int W = 119;
        boolean ans = solve(0, arr, 0, W);
        System.out.println(ans);

    }

}
