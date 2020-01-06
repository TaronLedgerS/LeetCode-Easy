package com.LeetCode.Easy7;

public class P459_RepeatedSubstringPattern {

//    public boolean repeatedSubstringPattern(String s) {
//        char[] chars = s.toCharArray();
//        if (s.length()==1) return true;
//        if (chars.length%2==1) {
//            for (char c : chars) {
//                if (c != chars[0]) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        for (int i = 0; i < chars.length / 2;i++) {
//            if (chars[i] != chars[i + chars.length / 2]) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        String s2 = s1.substring(1, s1.length() - 1);
        return s2.contains(s);
    }

    public static void main(String[] args) {
        System.out.println(new P459_RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
