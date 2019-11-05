package com.LeetCode.Easy3;

public class P191_Numberof1BitsTest {
    public static void main(String[] args) {
        int a = 43261596;

        Numberof1Bits temp = new Numberof1Bits();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(temp.hammingWeight(a));
    }
}
class Numberof1Bits{
    public  int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}