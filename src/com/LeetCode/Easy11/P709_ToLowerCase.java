package com.LeetCode.Easy11;

public class P709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A'&&(chars[i]<='Z'))
                chars[i] = (char)(chars[i]-'A' +'a');
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        System.out.println(
                new P709_ToLowerCase().toLowerCase("Hello")
        );
    }
}
