package com.LeetCode.Easy4;

import java.util.HashSet;
import java.util.Set;

public class P219_ContainsDuplicateIITest {
    public static void main(String[] args) {
        int[] nums ={2,1,6,1,1,2,3};
        ContainsDuplicateII temp =new ContainsDuplicateII();
        System.out.println(temp.containsNearbyDuplicate(nums,2));
    }
}

class ContainsDuplicateII{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;

    }

}
