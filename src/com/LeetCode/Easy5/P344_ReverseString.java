package com.LeetCode.Easy5;

public class P344_ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0,j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
    public static void main(String[] args) {
        P344_ReverseString test = new P344_ReverseString();
        String str ="hello";
        test.reverseString(str.toCharArray());
    }
}
