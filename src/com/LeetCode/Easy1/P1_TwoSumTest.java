package com.LeetCode.Easy1;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSumTest {
    public  static  void main(String[] args ){
        int nums[]= {1,2,3,4};
        int[] ans;
        ans = TwoSum.twoSum1(nums,6);
        if (ans!=null) {
            System.out.println("result" + ans[0] + ans[1]);
        }
    }
}class TwoSum {
     static int[] twoSum1(int[] nums, int target) {
            for(int i = 0;i<nums.length-1;i++){
                for(int j = i+1;j<nums.length;j++){
                    if (nums[i]+nums[j]==target) {
                        int[] ans = new int[2];
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
            return  null;
    }
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> tmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if (tmap.containsKey(temp)){//匹配成功
                return new int[]{tmap.get(temp),i};
            }//匹配失败，存入tmap候选
            tmap.put(nums[i],i);
        }
        return  null;
    }
}

