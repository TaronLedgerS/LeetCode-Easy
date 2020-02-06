package com.LeetCode.Easy10;

public class P657_RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'R') x++;
            else if (ch == 'L') x--;
        }
        return x == 0 && y == 0;
    }
    public static void main(String[] args) {
        System.out.println(
                new P657_RobotReturntoOrigin().judgeCircle("LLRR")
        );
    }
}
