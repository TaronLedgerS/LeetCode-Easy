package com.LeetCode.Easy13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int SumA = 0, SumB = 0;
        for (int i:A) SumA += i;
        for (int i:B) SumB += i;
        int DELTA = (SumB - SumA) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int i:B) setB.add(i);
        for (int x:A)
            if (setB.contains(x + DELTA)) {
                return new int[]{x, x + DELTA};
            }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P888_FairCandySwap().fairCandySwap(
                        new int[]{1,2,5},new int[]{2,4}
                )
        ));
    }
}
