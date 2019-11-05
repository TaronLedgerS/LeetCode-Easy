package com.LeetCode.Easy2;

import java.util.Arrays;

public class P136_SingleNumberTest {
    public static  void main(String[] args) {
        SingleNumberTest temp = new SingleNumberTest();
        int[] nums = {4,1,2,1,2};
        System.out.println(nums.length);
        System.out.println(temp.singleNumber(nums));
        System.out.println(Arrays.toString(nums));
    }
}
class SingleNumberTest{
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;//异或运算
        }
        return result;
    }
}