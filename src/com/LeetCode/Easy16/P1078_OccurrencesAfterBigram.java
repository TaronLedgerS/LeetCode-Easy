package com.LeetCode.Easy16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1078_OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] texts = text.split(" ");
        for (int i = 0; i < texts.length - 2; i++) {
            if (texts[i].equals(first)&&texts[i+1].equals(second)) ans.add(texts[i+2]);
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1078_OccurrencesAfterBigram().findOcurrences(
                "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa",
                "jkypmsxd"
        )));
    }
}
