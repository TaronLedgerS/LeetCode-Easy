package com.LeetCode.Easy8;

public class P541_ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int j = i;
            int l = Math.min(chars.length, j + k)-1;
            //颠倒j到l
            while (j < l) {
                char tmp = chars[j];
                chars[j] = chars[l];
                chars[l] = tmp;
                j++;l--;
            }
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        System.out.println(
                new P541_ReverseStringII().reverseStr("abcdefg",2)
        );
    }
}
