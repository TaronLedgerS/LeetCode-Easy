package com.LeetCode.Easy10;

import java.util.Arrays;

public class P645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int[] res = new int[2];
        for (int num : nums) {
            count[num - 1]++;
            if (count[num - 1] == 2) {
                res[0] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new P645_SetMismatch().findErrorNums(
                                new int[]{1, 2, 2, 4, 5}
                        )
                )
        );
    }
}
