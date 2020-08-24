package com.LeetCode.Easy22;

import java.util.ArrayList;
import java.util.List;

public class P1560_MostVisitedSectorInaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int len = rounds.length, fr = rounds[0], to = rounds[len - 1];
        List<Integer> res = new ArrayList<>();
        if (to >= fr) {     // no circle, such as [1,3,1,2]
            for (int i = fr; i <= to; i++) res.add(i);
        } else {            // cross a circle, such as [2,3,2,1]
            for (int i = 1; i <= n; i++) {
                if (i == to + 1) i = fr;
                res.add(i);
            }
        }
        return res;
    }
}
