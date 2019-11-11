package com.LeetCode.Easy4;

import java.util.Arrays;
import java.util.Scanner;

public class P242_ValidAnagramTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram1(s,t));
        System.out.println(validAnagram.isAnagram2(s,t));
    }
}
class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int j = t.charAt(i)-'a';
            table[j]--;
            if (table[j] < 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}