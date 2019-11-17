package com.LeetCode.Easy5;

import java.util.Scanner;

public class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = (1+n)*n/2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        P268_MissingNumber test = new P268_MissingNumber();
        System.out.println(test.missingNumber(nums));
    }
}
