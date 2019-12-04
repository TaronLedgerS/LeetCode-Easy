package com.LeetCode.Easy6;

import java.util.HashSet;

public class P409_LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> tmpSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (tmpSet.contains(s.charAt(i))) {
                tmpSet.remove(s.charAt(i));
                count++;
            }else{
                tmpSet.add(s.charAt(i));
            }
        }
        if (!tmpSet.isEmpty()) return count * 2 + 1;
        return count*2;
    }
    public static void main(String[] args) {

        P409_LongestPalindrome test = new P409_LongestPalindrome();
        System.out.println(test.longestPalindrome("abbcccdd"));
    }
}
