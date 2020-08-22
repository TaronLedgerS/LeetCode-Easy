package com.LeetCode.Easy19;

import java.util.PriorityQueue;

public class P1337_TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        int[] ans = new int[k];
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{numOnes(mat[i]), i});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) {
            ans[--k] = pq.poll()[1];
        }
        return ans;
    }

    private int numOnes(int[] row) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (row[m] == 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
