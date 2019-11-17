package com.LeetCode.Easy5;

import java.util.Arrays;
import java.util.Scanner;

public class P283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index < i) {
                    nums[index] = nums[i];
                    nums[i]=0;
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        P283_MoveZeroes test = new P283_MoveZeroes();
        test.moveZeroes(nums);
    }
}
