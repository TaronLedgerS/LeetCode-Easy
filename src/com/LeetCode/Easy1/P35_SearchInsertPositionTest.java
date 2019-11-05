package com.LeetCode.Easy1;

import java.util.Arrays;

public class P35_SearchInsertPositionTest {
    public static void main(String[] args){
        SearchInsertPosition temp = new SearchInsertPosition();
        int[] nums = {1,3,5,6} ;
        System.out.println(nums.length);
        System.out.println(temp.searchInsert(nums,7));
        System.out.println(Arrays.toString(nums));
    }
}
class SearchInsertPosition {
    int searchInsert(int[] nums, int target) {
        int i =0;
        while(i < nums.length && nums[i]<target ){
            i++;
        }
        return  i;
    }
}