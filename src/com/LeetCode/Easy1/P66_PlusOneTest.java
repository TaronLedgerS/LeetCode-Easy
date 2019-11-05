package com.LeetCode.Easy1;

import java.util.Arrays;

public class P66_PlusOneTest {
    public static void main(String[] args){
        PlusOne temp = new PlusOne();
        int[] nums = {9,9,9} ;
        System.out.println(nums.length);
        System.out.println(Arrays.toString(temp.plusOne(nums)));
    }
}
class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) {
            return new int[]{1};
        }
        int i = digits.length - 1;
        digits[i] = digits[i]+1;
        while(i>0&&  digits[i]> 9 ){
            digits[i] = 0;
            i--;
            digits[i] = digits[i]+1;//进位
        }
        if (digits[0]<=9){
            return digits;
        }else{//最高位需要进位
            int[] newdigits = new int[digits.length+1];
            newdigits[0] = 1;
            newdigits[1] = 0;
            for ( i = 1;i<digits.length;i++){
                newdigits[i+1] = digits[i];
            }
            return newdigits;
        }
    }
}