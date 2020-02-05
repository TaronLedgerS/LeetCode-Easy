package com.LeetCode.Easy9;

public class P605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
    public static void main(String[] args) {
        System.out.println(
                new P605_CanPlaceFlowers().canPlaceFlowers(
                        new int[]{1,0,0,0,1},1
                )
        );
    }
}
