package com.LeetCode.Easy3;


public class P169_MajorityElementTest {
    public static void main(String[] args) {
        int[] nums ={2,1,1,6,1,1,1,2,3};
        MajorityElement temp = new MajorityElement();
        System.out.println(temp.majorityElement(nums));

    }
}

class MajorityElement{
    public int majorityElement(int[] nums) {
        int majorVoteNum = nums[0];
        int count =1;
        for(int i = 1;i<nums.length;i++){
            if (count == 0) {
                majorVoteNum = nums[i];
                count++;
            }else{
                if(majorVoteNum == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }

        }
        return majorVoteNum;
    }
}

