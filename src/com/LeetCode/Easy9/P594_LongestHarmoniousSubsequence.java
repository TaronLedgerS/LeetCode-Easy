package com.LeetCode.Easy9;

import java.util.HashMap;
import java.util.Map;

public class P594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int num : nums) {
            dataMap.put(num, dataMap.getOrDefault(num, 0) + 1);
        }
        for (int key : dataMap.keySet()) {
            if (dataMap.containsKey(key + 1)) {
                res = Math.max(res, dataMap.get(key) + dataMap.get(key + 1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P594_LongestHarmoniousSubsequence().findLHS(
                        new int[]{1,3,2,2,5,2,3,7}
                )
        );
    }
}
