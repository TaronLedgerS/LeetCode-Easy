package com.LeetCode.Easy10;

public class P693_BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P693_BinaryNumberwithAlternatingBits().hasAlternatingBits(5)
        );
    }
}
