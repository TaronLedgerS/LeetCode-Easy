package com.LeetCode.Easy5;

import java.util.Scanner;

public class P303_RangeSumQueryImmutable {

    private  int[] sums;
    public P303_RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        P303_RangeSumQueryImmutable test = new P303_RangeSumQueryImmutable(nums);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        System.out.println(test.sumRange(i,j));
    }
}
