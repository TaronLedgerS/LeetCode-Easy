package com.LeetCode.Easy7;

import java.util.Arrays;

public class P506_RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        //选手编号
        Integer[] rank = new Integer[nums.length];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = i;
        }
        //按成绩从大到小排名次，并将选手编号按名次放进index数组中，即第i+1名的选手编号为rank[i]
        Arrays.sort(rank,(a,b)->(nums[b]-nums[a]));
        //System.out.println(Arrays.toString(rank));
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[rank[i]] = "Gold Medal";
            }else if (i == 1) {
                res[rank[i]] = "Silver Medal";
            }else if (i == 2) {
                res[rank[i]] = "Bronze Medal";
            }else{
                res[rank[i]] = (i + 1) + "";
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P506_RelativeRanks().findRelativeRanks(new int[]{10,3,8,9,4})
        ));
    }
}
