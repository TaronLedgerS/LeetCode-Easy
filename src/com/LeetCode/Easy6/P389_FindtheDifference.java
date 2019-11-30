package com.LeetCode.Easy6;

public class P389_FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a'] -=1;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return t.charAt(0);
    }
    public static void main(String[] args) {
        P389_FindtheDifference test = new P389_FindtheDifference();
        System.out.println(test.findTheDifference("abcd", "abcde"));
    }
}
