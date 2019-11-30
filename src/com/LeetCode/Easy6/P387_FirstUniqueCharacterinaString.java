package com.LeetCode.Easy6;

import java.util.Arrays;

public class P387_FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == -1) {
                arr[s.charAt(i) - 'a'] = i;
            } else {
                if (arr[s.charAt(i) - 'a'] >=0) {
                    arr[s.charAt(i) - 'a'] = -2;
                }
            }
        }
        int ans = -1;
        for (int value:arr) {
            if (value >= 0 ) {
                if (ans == -1) {
                    ans = value;
                } else {
                    ans = Math.min(ans, value);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        P387_FirstUniqueCharacterinaString test = new P387_FirstUniqueCharacterinaString();
        System.out.println(test.firstUniqChar("loveleetcode"));
    }
}
