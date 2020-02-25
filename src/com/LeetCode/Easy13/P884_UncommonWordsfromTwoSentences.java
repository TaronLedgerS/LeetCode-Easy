package com.LeetCode.Easy13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P884_UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s:A.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s:B.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        List<String> ans = new LinkedList<>();
        for (String s : map.keySet())
            if (map.get(s)==1) ans.add(s);
        return ans.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P884_UncommonWordsfromTwoSentences().uncommonFromSentences(
                        "this apple is sweet","this apple is sour"
                ))
        );
    }
}
