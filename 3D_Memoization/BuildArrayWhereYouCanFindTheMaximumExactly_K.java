package Level_1;

import java.util.Arrays;

class BuildArrayWhereYouCanFindTheMaximumExactly_K {
    static int[][][] dp;
    static int MOD = 1000000007;
    public static int solve(int index, int n, int m, int k, int max, int cost)
    {
        if(index >= n || cost > k)
        {
            if(cost == k)
            {
                return 1;
            }
            return 0;
        }

        if(dp[index][max][cost] != -1) return dp[index][max][cost];
        int a = 0;
        for(int i = 1; i<=m;i++)
        {
            if(max < i)
                a = (a + solve(index + 1, n , m ,k, i, cost + 1))%MOD;
            else{
                a = (a + solve(index + 1, n, m, k,max, cost))%MOD;
            }
        }
        return dp[index][max][cost] = a;

    }
    public static int numOfArrays(int n, int m, int k) {
        return solve(0, n, m, k, 0, 0);
    }

    public static void main(String[] args) {
        int n = 50 ,m = 100 ,k= 25 ;
        dp = new int[n+1][m+1][k+1];

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int numOfArrays = numOfArrays(n, m, k);
        System.out.println(numOfArrays);
    }
}