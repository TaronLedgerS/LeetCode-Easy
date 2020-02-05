package com.LeetCode.Easy9;

import java.util.*;

public class P599_MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i< list1.length;i++)
            map.put(list1[i],i);
        int sum = list1.length + list2.length;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tsum = map.get(list2[i]) + i;
                if (tsum < sum) {
                    sum = tsum;
                    res.clear();
                    res.add(list2[i]);
                }else if (sum == tsum)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                    new P599_MinimumIndexSumofTwoLists().findRestaurant(
                            new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                            new String[]{"KFC","Burger King","Tapioca Express","Shogun"}
                    )
                )
        );
    }
}
