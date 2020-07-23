package com.LeetCode.Easy15;

import java.util.Arrays;

public class P1033_MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] m = new int[] {a, b, c};
        Arrays.sort(m);
        int left = m[1] - m[0] - 1;
        int right = m[2] - m[1] - 1;
        return new int[] {
                //      cases:    XX___X                X___XX              X_X_X
                Math.min((left > 0 ? 1 : 0) + (right > 0 ? 1 : 0), (left == 1 || right == 1 ? 1 : 2)),
                left + right};   // X___________X___________X
    }
}
