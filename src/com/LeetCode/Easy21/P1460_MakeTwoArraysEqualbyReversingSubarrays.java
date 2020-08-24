package com.LeetCode.Easy21;

import java.util.Arrays;

public class P1460_MakeTwoArraysEqualbyReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
