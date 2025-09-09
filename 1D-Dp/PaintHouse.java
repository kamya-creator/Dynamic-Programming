package Level_1._1D_Based_DP;

public class PaintHouse {
    static char[] colors = {'r','g','b'};
    static int ans = Integer.MAX_VALUE;
    public static int solve(int index, int N, char prevColor, int[] r, int[] g, int[] b, int csf)
    {
        if(index >= N)
        {
            ans = Math.min(ans, csf);

            return csf;
        }

        for(int i = 0;i<3;i++)
        {
            if(colors[i] != prevColor)
            {
                int cost = 0;
                if(i == 0) cost = r[index] ;
                if(i == 1) cost = g[index] ;
                if(i == 2) cost = b[index] ;
                System.out.println(cost + " " + colors[i] + " " + index);
                solve(index + 1, N, colors[i], r, g, b, csf + cost);
            }
        }
        return ans;
    }
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        // code here
        int a = solve(0, N, 'a', r, g, b, 0);
        System.out.println("Final Ans " + a);
        return ans;
    }

    public static void main(String[] args) {

        int N = 7;
        int r[] = {95, 9, 37, 15, 64, 86, 41};
        int g[] = {87, 5, 31, 10, 28, 4, 92};
        int b[] = {90, 49, 68, 50, 76, 67, 70};
        distinctColoring(N, r, g, b);
    }
}
