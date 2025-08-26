package Level_1.Knapsack.Last_Stone_2;

public class Last_Stone_II_Recursive {
    static int range;
    public static int solve(int index, int[] arr, int ssf)
    {
        if(index >= arr.length) return Math.abs(range - 2*ssf);

        int take = solve(index + 1, arr, ssf + arr[index]);
        int skip = solve(index + 1, arr, ssf);
        return Math.min(take, skip);
    }
    public static void main(String[] args) {

        int[] arr = {31,26,33,21,40};
        for (int a : arr) range+=a;
        int ans = solve(0, arr, 0);
        System.out.println(ans);
    }
}
