package com.LeetCode.Easy1;

import java.util.Arrays;

public class P27_RemoveElementTest {
    public static void main(String[] args){
        RemoveElement temp = new RemoveElement();
        int[] nums = {1,1,2,3} ;
        System.out.println(temp.removeElement(nums,2));
        System.out.println(Arrays.toString(nums));

    }
}
class RemoveElement {
    int removeElement(int[] nums, int val) {
        int length = nums.length;
        if(length == 0)
            return 0;
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i]!=val){//保留不是val的值在数组前面
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
