package com.LeetCode.Easy8;

import java.util.HashSet;
import java.util.Set;

public class P575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) {
            kinds.add(candy);
        }
        return  Math.min(kinds.size(), (candies.length / 2));
    }

    public static void main(String[] args) {
        System.out.println(
                new P575_DistributeCandies().distributeCandies(new int[]{1,1,2,2,2,2})
        );
    }
}
