package com.LeetCode.Easy19;

import java.util.PriorityQueue;

public class P1356_SortIntegersbyTheNumberof1Bits {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        for (int a : arr) {
            int count = calcualte1Bit(a);
            minHeap.offer(new int[]{count, a});
        }
        int[] res = new int[arr.length];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll()[1];
        }
        return res;
    }
    private int calcualte1Bit(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
