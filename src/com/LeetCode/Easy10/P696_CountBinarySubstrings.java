package com.LeetCode.Easy10;

import java.util.ArrayList;
import java.util.List;

public class P696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> group = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                group.add(count);
                count = 1;
            }
        }
        group.add(count);
        count = 0;
        for (int i = 1; i < group.size(); i++) {
            count += Math.min(group.get(i), group.get(i - 1));
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(
                new P696_CountBinarySubstrings().countBinarySubstrings(
                        "000110011"
                )
        );
    }
}
