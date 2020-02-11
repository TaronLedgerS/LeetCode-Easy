package com.LeetCode.Easy11;

import java.util.PriorityQueue;

public class P703_KthLargestElementinaStream {
    final PriorityQueue<Integer> kthLargestQueue;
    final int k;
    public P703_KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        kthLargestQueue = new PriorityQueue<>(k);
        for (int n:nums)
            add(n);
    }
    public int add(int val) {
        kthLargestQueue.offer(val);
        if (kthLargestQueue.size() > k) {
            kthLargestQueue.poll();
        }
        return kthLargestQueue.peek();
    }
    public static void main(String[] args) {
        P703_KthLargestElementinaStream temp = new P703_KthLargestElementinaStream(3,new int[]{4,5,8,2});
        System.out.println(temp.add(3));
        System.out.println(temp.add(5));
        System.out.println(temp.add(10));
        System.out.println(temp.add(9));
        System.out.println(temp.add(4));

    }
}
