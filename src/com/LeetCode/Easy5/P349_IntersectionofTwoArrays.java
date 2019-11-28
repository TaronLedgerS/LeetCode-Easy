package com.LeetCode.Easy5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value:nums2) {
            if (set.contains(value)) {
                res.add(value);
                set.remove(value);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        P349_IntersectionofTwoArrays test = new P349_IntersectionofTwoArrays();
        System.out.println(Arrays.toString(test.intersection(nums1,nums2)));
    }
}
