package com.LeetCode.Easy18;

import java.util.HashSet;
import java.util.Set;

public class P1207_UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //array to store number of occurances
        int[] c = new int[2001];
        //count occurance of each value
        for (int n : arr) {
            c[n+1000]++;
        }
        //check unique occurances (except for 0)
        Set<Integer> set = new HashSet();
        for (int count : c) {
            if (count == 0)
                continue;
            if (!set.add(count))
                return false;
        }
        return true;
    }
}
