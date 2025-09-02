package Level_1.LCS;

public class LCS_Recurssion {
    static int solve(String s1, String s2, int n , int m)
    {
        if(n < 0 || m < 0) return 0;

        if(s1.charAt(n) == s2.charAt(m))
        {
            return 1 + solve(s1, s2, n - 1, m - 1);
        }
        else{

            int a = solve(s1,s2, n, m-1);
            int b = solve(s1, s2, n - 1, m);
            return Math.max(a,b);
        }
    }
    static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        return solve(s1, s2, n-1, m - 1);
    }
    public static void main(String[] args) {

        String s1 = "ABCDGH", s2 = "AEDFHR";
        int ans = lcs(s1, s2);
        System.out.println(ans);
    }
}
