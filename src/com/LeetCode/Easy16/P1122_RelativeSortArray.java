package com.LeetCode.Easy16;

import java.util.Arrays;

public class P1122_RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P1122_RelativeSortArray().relativeSortArray(
                        new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6}
                )
        ));
    }
}
