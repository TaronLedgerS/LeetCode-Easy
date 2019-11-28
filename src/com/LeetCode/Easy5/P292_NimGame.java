package com.LeetCode.Easy5;

import java.util.Scanner;

public class P292_NimGame {
    public boolean canWinNim(int n) {

        return !(n%4==0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P292_NimGame test = new P292_NimGame();
        System.out.println(test.canWinNim(n));
    }
}
