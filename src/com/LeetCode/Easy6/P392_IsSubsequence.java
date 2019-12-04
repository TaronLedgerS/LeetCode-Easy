package com.LeetCode.Easy6;

public class P392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(indexS) == t.charAt(i)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P392_IsSubsequence test = new P392_IsSubsequence();
        System.out.println(test.isSubsequence("axc","ahbgdc"));
    }
}
