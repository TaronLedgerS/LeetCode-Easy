package com.LeetCode.Easy5;

import java.util.Arrays;

public class P350_IntersectionofTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i];
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return Arrays.copyOf(res, k);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        P350_IntersectionofTwoArraysII test = new P350_IntersectionofTwoArraysII();
        System.out.println(Arrays.toString(test.intersection(nums1,nums2)));
    }
}
