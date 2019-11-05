package com.LeetCode.Easy1;

import java.util.Arrays;

public class P88_MergeSortedArrayTest {
    public static void main(String[] args){
        MergeSortedArray temp = new MergeSortedArray();
        int[] nums1 = {1,1,2,0,0,0};
        int[] nums2 = {1,2,3};
        temp.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) {
            A[k--] = B[j--];
        }
    }
}