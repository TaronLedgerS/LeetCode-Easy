package com.LeetCode.Easy4;

import java.util.HashSet;
import java.util.Set;

public class P217_ContainsDuplicateTest {

    public static void main(String[] args) {
        int[] nums ={2,1,6,1,1,2,3};
        ContainsDuplicate temp =new ContainsDuplicate();
        System.out.println(temp.containsDuplicate(nums));

    }
}
class ContainsDuplicate{
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for(int x:nums){
            if (hashset.contains(x)){
                return true;
            }
            hashset.add(x);
        }
        return false;
    }
}

