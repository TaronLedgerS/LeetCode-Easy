package com.LeetCode.Easy7;

public class P485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0,temp = 0;
        for (int val:nums) {
            if (val == 0) {
                ans = Math.max(ans, temp);
                temp=0;
            }else
                temp++;
        }
        ans = Math.max(ans, temp);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new P485_MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,1,0,1,1}));
    }
}
