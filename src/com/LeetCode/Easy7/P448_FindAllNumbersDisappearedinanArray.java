package com.LeetCode.Easy7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P448_FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i<n;i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(new P448_FindAllNumbersDisappearedinanArray().findDisappearedNumbers(nums));
    }
}
