package com.LeetCode.Easy8;

public class P521_LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
    public static void main(String[] args) {
        System.out.println(new P521_LongestUncommonSubsequenceI().findLUSlength("abc","bcd"));
    }
}
