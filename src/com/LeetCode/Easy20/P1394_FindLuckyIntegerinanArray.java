package com.LeetCode.Easy20;

import java.util.HashMap;
import java.util.Map;

public class P1394_FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ans = -1;
        for (int a : map.keySet()) {
            if (a == map.get(a)) {
                if (a>ans) ans = a;
            }
        }
        return ans;
    }
}
