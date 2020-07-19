package com.LeetCode.Easy15;

public class P1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] count = new int[60];
        for (int a : time) count[a % 60]++;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) res += (count[i]) * (count[i] - 1) / 2;
            else
                res += count[i] * count[60 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1010_PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(
                new int[]{30, 20, 150, 100, 40}
        ));
    }
}
