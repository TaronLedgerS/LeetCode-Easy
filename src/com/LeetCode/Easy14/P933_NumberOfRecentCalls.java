package com.LeetCode.Easy14;
import java.util.*;

public class P933_NumberOfRecentCalls {
    public static void main(String[] args) {

    }
}
class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    public int ping(int t) {
        q.offer(t);
        while (null != q.peek() && q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
