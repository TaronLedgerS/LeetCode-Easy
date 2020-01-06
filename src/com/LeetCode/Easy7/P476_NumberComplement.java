package com.LeetCode.Easy7;

public class P476_NumberComplement {
    public int findComplement(int num) {
        //与全1做疑惑运算
        return num^((Integer.highestOneBit(num)<<1) - 1);
    }
    public static void main(String[] args) {
        System.out.println(new P476_NumberComplement().findComplement(1));
    }
}
