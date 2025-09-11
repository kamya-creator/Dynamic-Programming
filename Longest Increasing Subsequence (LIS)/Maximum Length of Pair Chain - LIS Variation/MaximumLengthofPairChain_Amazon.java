package Level_1.LongestIncreasingSubsequence.LIS_Variations;

import java.util.Arrays;

public class MaximumLengthofPairChain_Amazon {
    public  static int solve(int index, int[][] pairs, int pre_index)
    {
        if(index >= pairs.length) return 0;

        int skip = solve(index + 1, pairs, pre_index);
        int take = 0;
        if(pre_index == -1 || pairs[pre_index][1] < pairs[index][0])
        {
            take = 1 + solve(index + 1, pairs, index);
        }
        return Math.max(take, skip);
    }
    public  static int findLongestChain(int[][] pairs) {

        // Ques m mention h order matter nhi krta so yes we can sort
        // Sorting is required qki subsequence m backward nhi jate hamesha aage hi jate h isliye sorting make sure ki aage sirf bade pairs hi rahe
        // har pair ke pass 2 choices h ki either be part of increasing subsequence or not be part
        // Take m bs ye dhayan rakhna h ki vhi pair lo jiska (b < c) h , pairs we have (a, b) and (c, d)
        Arrays.sort(pairs, (a , b) -> a[0] - b[0]);
        return solve(0, pairs, -1);
    }
    public static void main(String[] args) {

    }
}
