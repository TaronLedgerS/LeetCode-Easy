package com.LeetCode.Easy13;

public class P860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill==5) five++;
            if (bill==10){
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                }else
                    five = five-3;
            }
            if (five<0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P860_LemonadeChange().lemonadeChange(new int[]{5,5,5,10,20})
        );
    }
}
