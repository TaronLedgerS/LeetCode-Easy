package com.LeetCode.Easy15;

import java.util.PriorityQueue;

public class P1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int stone : stones) {
            maxheap.offer(stone);
        }
        while (maxheap.size() > 1) {
            int y = maxheap.poll();
            int x = maxheap.poll();
            if (y>x) maxheap.offer(y - x);
        }
        if (maxheap.size()==1) return maxheap.poll();
        else return 0;
    }
}
