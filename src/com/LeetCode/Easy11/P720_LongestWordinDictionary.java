package com.LeetCode.Easy11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P720_LongestWordinDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P720_LongestWordinDictionary().longestWord(
                        new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}
                )
        );
    }
}