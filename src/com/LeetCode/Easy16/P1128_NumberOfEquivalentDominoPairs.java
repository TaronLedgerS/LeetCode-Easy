package com.LeetCode.Easy16;

public class P1128_NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counts = new int[100];
        int res = 0;
        for (int[] d : dominoes) {
            int up = Math.min(d[0], d[1]);
            int down = Math.max(d[0], d[1]);
            res+=counts[up * 10 + down]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1128_NumberOfEquivalentDominoPairs().numEquivDominoPairs(
                new int[][]{{1,2},{2,1},{3,4},{5,6}}
        ));
    }
}
