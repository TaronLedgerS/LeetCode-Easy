package com.LeetCode.Easy2;

import java.util.Arrays;

public class P167_TwoSumIITest {
    public static void main(String[] args) {
        int[] nums ={2,5,6,7,10,18,20};
        TwoSum temp = new TwoSum();

        System.out.println(Arrays.toString(temp.twoSum(nums,7)));
        System.out.println(Arrays.toString(temp.twoSum(nums,12)));
    }
}
class TwoSum{
    int[] twoSum(int[] numbers,int target){
        int[] res=new int[2];
        int i=0;
        int j=numbers.length-1;
        while(numbers[i]+numbers[j]!=target){
            if((numbers[i]+numbers[j])>target){
                j--;
            } else{
                i++;
            }
        }
        res[0]=i+1;
        res[1]=j+1;
        return res;
    }
}