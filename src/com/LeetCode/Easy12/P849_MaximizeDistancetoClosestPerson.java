package com.LeetCode.Easy12;

public class P849_MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int k = 0;
        int ans = -1;
        for (int seat : seats) {
            if (seat == 1) {
                if (ans == -1) {
                    ans = k;
                } else
                    ans = Math.max(ans, (k + 1) / 2);
                k = 0;
            } else
                k++;
        }
        ans = Math.max(ans, k);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new P849_MaximizeDistancetoClosestPerson().maxDistToClosest(
                        new int[]{0,1,0,0,0}
                )
        );
    }
}
