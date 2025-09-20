package Level_2;

public class CatalanNumber_Recurssion {
    public static int solve(int n)
    {
        if( n == 0 || n == 1)
        {
            return 1;
        }
        int ans  = 0;
        for(int k = 1; k<=n ;k++)
        {
            ans+= solve(k - 1) * solve( n - k);
        }
        return ans;
    }
    public static int findCatalan(int n) {
        // code here
        return solve(n);
    }
    public static void main(String[] args) {
        int solve = solve(19);
        System.out.println(solve);
    }
}
