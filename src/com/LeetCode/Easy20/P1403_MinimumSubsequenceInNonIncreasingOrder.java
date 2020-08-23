package com.LeetCode.Easy20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1403_MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arr=new ArrayList<>();
        long sum=0;
        for(int i:nums)
            sum+=i;
        long ans=0;
        for(int i=nums.length-1;i>=0;i--){
            arr.add(nums[i]);
            ans+=nums[i];
            if(ans>sum-ans)
                return arr;
        }
        return arr;
    }
}
