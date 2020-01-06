package com.LeetCode.Easy7;

import java.util.Arrays;

public class P455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ans++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 1};
        System.out.println(new P455_AssignCookies().findContentChildren(a, b));
    }
}
