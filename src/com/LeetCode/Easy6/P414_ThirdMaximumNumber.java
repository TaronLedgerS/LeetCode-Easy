package com.LeetCode.Easy6;

public class P414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (a==nums[i]||b==nums[i]||c==nums[i]) continue;
            if (a == -1 || nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if (b == -1 || nums[i] > b) {
                c = b;
                b = nums[i];
            } else if(c==-1||nums[i]>c){
                c = nums[i];
            }
        }
        if (c != -1) {
            return c;
        } else  return a;
    }
    public static void main(String[] args) {
        P414_ThirdMaximumNumber test = new P414_ThirdMaximumNumber();
        int[] n = {2, 1, 2,3};
        System.out.println(test.thirdMax(n));
    }
}
