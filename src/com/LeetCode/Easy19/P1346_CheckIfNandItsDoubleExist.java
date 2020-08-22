package com.LeetCode.Easy19;

import java.util.Arrays;

public class P1346_CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int zeroCount = 0;
        for (int x : arr) {
            if (x != 0) {
                if (binarySearch(x, arr) && binarySearch(x*2, arr)) {
                    return true;
                }
            }
            else {
                ++zeroCount;
            }
        }
        return zeroCount >= 2;
    }

    public boolean binarySearch(int x, int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + ((end-start)>>>1);
            if (nums[mid] < x) {
                start = 1 + mid;
            }
            else if (nums[mid] > x) {
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
