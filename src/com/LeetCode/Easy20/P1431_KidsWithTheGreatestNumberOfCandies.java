package com.LeetCode.Easy20;

import java.util.ArrayList;
import java.util.List;

public class P1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] cs, int e) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();
        for (int n : cs) max = Math.max(n, max);
        for (int n : cs) res.add(n + e >= max);
        return res;
    }
}
