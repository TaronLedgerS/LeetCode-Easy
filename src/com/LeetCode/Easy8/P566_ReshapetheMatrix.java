package com.LeetCode.Easy8;

import java.util.Arrays;

public class P566_ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || (nums.length * nums[0].length != r * c)) {
            return nums;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = num[j];
                count++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] res = new P566_ReshapetheMatrix().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        for (int[] re : res) {
            System.out.println(
                    Arrays.toString(re)
            );
        }
    }
}
