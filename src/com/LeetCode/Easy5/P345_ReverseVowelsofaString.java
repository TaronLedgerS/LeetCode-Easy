package com.LeetCode.Easy5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P345_ReverseVowelsofaString {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char c[] = s.toCharArray();
        int i=0,j=s.length()-1;
        while (i < j) {
            while (i<s.length()&&!vowels.contains(c[i])){
                i++;
            }
            while (j > 0 && !vowels.contains(c[j])) {
                j--;
            }
            if (i < j) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;j--;
            }
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        P345_ReverseVowelsofaString test = new P345_ReverseVowelsofaString();
        String str ="hello";
        System.out.println(test.reverseVowels(str));
    }
}
