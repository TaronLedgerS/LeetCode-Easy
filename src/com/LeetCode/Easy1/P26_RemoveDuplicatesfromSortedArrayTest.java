package com.LeetCode.Easy1;

import java.util.Arrays;

public class P26_RemoveDuplicatesfromSortedArrayTest {
    public static void main(String[] args){
        RemoveDuplicatesfromSortedArray temp = new RemoveDuplicatesfromSortedArray();
        int[] nums = {1,1,2,3} ;
        System.out.println(temp.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
class RemoveDuplicatesfromSortedArray {
     int removeDuplicates(int[] nums) {
         int length = nums.length;
         if(length == 0)
             return 0;
         int len = 1;
         for(int i = 0;i<nums.length-1;i++){
             if (nums[i]!=nums[i+1]){
                 nums[len] = nums[i+1];
                 len++;
             }
         }
         return len;
    }
}