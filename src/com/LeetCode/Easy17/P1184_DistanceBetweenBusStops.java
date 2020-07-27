package com.LeetCode.Easy17;

public class P1184_DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res = Integer.MAX_VALUE;
        int n = distance.length;
        int i = start;
        int dis = 0;
        while (i != destination) {
            dis += distance[i++];
            i = i % n;
        }
        res = Math.min(res, dis);
        dis = 0;
        i = start;
        while (i != destination) {
            i = (i-1+n) % n;
            dis += distance[i];
        }
        res = Math.min(res, dis);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1184_DistanceBetweenBusStops().distanceBetweenBusStops(
                new int[]{1,2,3,4},0,3
        ));
    }
}


