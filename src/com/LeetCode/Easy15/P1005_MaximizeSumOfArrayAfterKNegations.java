package com.LeetCode.Easy15;

import java.util.PriorityQueue;
import java.util.Queue;

public class P1005_MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int result = 0;
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int a:A) minHeap.offer(a);

        while (K > 0) {
            int a = minHeap.remove();
            if (a < 0) {
                minHeap.offer(-a);
            } else {
                K = K % 2;
                if (K > 0) {
                    minHeap.offer(-a);
                } else {
                    minHeap.offer(a);
                }
            }
            K--;
        }

        for (int a:minHeap) result += a;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1005_MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(
                new int[]{2,-3,-1,5,-4},2
        ));
    }
}
