package com.LeetCode.Easy7;

import java.util.Arrays;

public class P475_Heaters {
    //错误：未考虑加热器未放在房子并远离房子的情况
//    public int findRadius(int[] houses, int[] heaters) {
//        int dis=0;
//        Arrays.sort(heaters);
//        Arrays.sort(houses);
//        dis = Math.max(heaters[0] - 1, houses[houses.length - 1] - heaters[heaters.length-1]);
//
//        if (heaters.length > 1) {
//            for (int i = 0; i < heaters.length - 1; i++) {
//                int temp = heaters[i+1]-heaters[i]-1;
//                temp = (temp%2)==1?temp/2+1:temp/2;
//                dis = Math.max(dis, temp );
//            }
//        }
//        return dis;
//    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            //确定每个房子属于哪个加热器的范围内
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P475_Heaters().findRadius(new int[]{1,2,3,4,5},new int[]{1,5}));
    }
}
