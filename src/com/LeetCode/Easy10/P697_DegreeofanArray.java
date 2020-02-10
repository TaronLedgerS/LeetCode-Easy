package com.LeetCode.Easy10;

import java.util.HashMap;

public class P697_DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P697_DegreeofanArray().findShortestSubArray(
                        new int[]{1,3,2,2,3,1}
                )
        );
    }
}
