package com.LeetCode.Easy20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P1408_StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            while (j < words.length) {
                int index = words[j++].indexOf(words[i]);
                if (index != -1) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
