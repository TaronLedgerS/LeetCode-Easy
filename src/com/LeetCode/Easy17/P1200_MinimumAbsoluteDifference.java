package com.LeetCode.Easy17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P1200_MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDist = Integer.MAX_VALUE;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int dist = arr[i + 1] - arr[i];
            if (dist < minDist) {
                minDist = dist;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (dist==minDist){
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
