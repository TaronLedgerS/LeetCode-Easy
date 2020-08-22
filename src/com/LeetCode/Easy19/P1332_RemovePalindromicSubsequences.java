package com.LeetCode.Easy19;

public class P1332_RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 1;
        else return 2;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!(s.charAt(left++) == s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}
