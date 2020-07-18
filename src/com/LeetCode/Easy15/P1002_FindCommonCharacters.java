package com.LeetCode.Easy15;

import java.util.ArrayList;
import java.util.List;

public class P1002_FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {

            int minCount = Integer.MAX_VALUE;
            for (String s : A) {
                int count = 0;
                for (char ch:s.toCharArray())
                    if (ch==c) count++;
                minCount = Math.min(minCount, count);
            }
            for (int i = 0; i < minCount; i++)
                result.add("" + c);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1002_FindCommonCharacters().commonChars(
                new String[]{
                        "bella","label","roller"
                }
        ));
    }
}
