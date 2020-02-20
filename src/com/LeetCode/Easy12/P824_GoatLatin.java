package com.LeetCode.Easy12;

import java.util.HashSet;
import java.util.Set;

public class P824_GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> Vowel =new HashSet<>();
        for (char c:new char[]{'a','e','i','o','u','A','E','I','O','U',})
            Vowel.add(c);

        StringBuilder ans = new StringBuilder();
        String[] words = S.split(" ");
        int count = 0;
        for (String w : words) {
            count++;
            if (Vowel.contains(w.charAt(0))) {
                ans.append(w);
            } else {
                ans.append(w.substring(1));
                ans.append(w.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0;i<count;i++)
                ans.append('a');
            ans.append(' ');
        }
        return ans.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(
                new P824_GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog")
        );
    }
}
