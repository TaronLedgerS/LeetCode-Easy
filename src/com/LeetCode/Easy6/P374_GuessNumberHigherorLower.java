package com.LeetCode.Easy6;

import java.util.Scanner;

public class P374_GuessNumberHigherorLower {
    private int pick;

    P374_GuessNumberHigherorLower(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        if (num == pick) {
            return 0;
        }
        return num>pick?-1:1;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pick = scanner.nextInt();
        P374_GuessNumberHigherorLower test = new P374_GuessNumberHigherorLower(pick);
        System.out.println(test.guessNumber(n));
    }
}
