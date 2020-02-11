package com.LeetCode.Easy11;

public class P704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            if (nums[m]==target) return m;
            if (nums[m]>target) r = m-1;
            if (nums[m]<target) l =l+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P704_BinarySearch().search(new int[]{-1,0,3,5,9,12},9)
                        +" | "+
                new P704_BinarySearch().search(new int[]{-1,0,3,5,9,12},7)
                        +" | "+
                new P704_BinarySearch().search(new int[]{-1},-1)
        );
    }
}
