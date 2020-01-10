package com.LeetCode.Easy8;

import java.util.HashMap;
import java.util.Map;

public class P532_KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        //临界判断
        if (nums ==null||nums.length==0||k<0) return 0;
        int count = 0;
        //建立哈希表
        Map<Integer, Integer> countMap = new HashMap<>();//<元素，出现次数>
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        //统计
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (k == 0) {//距离为0，即重复元素
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (countMap.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new P532_KdiffPairsinanArray().findPairs(
                new int[]{1,2,3,4,5},1
        ));
    }
}
