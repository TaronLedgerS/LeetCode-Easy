package com.LeetCode.Easy5;

import java.util.Scanner;

public class P299_BullsandCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretT = new int[10];
        int[] guessT = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }else {
                secretT[secret.charAt(i)-'0'] += 1;
                guessT[guess.charAt(i)-'0'] += 1;
            }
         }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretT[i], guessT[i]);
        }
        return bulls+"A"+cows+"B";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P299_BullsandCows test = new P299_BullsandCows();
        String secret = sc.nextLine();
        String guess = sc.nextLine();
        System.out.println(test.getHint(secret,guess));
    }
}
