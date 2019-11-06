package com.LeetCode.Easy4;

import java.util.Scanner;

public class P231_PowerofTwoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PowerofTwo temp = new PowerofTwo();
        int t;
        while ((t = sc.nextInt())!=-1){
//            int t1=t;
//            int t2=t;
//            System.out.println("t1:"+Integer.toBinaryString(t1));
//            System.out.println("t1>>=1:"+ Integer.toBinaryString(t1>>=1));
//            System.out.println("t1:"+Integer.toBinaryString(t1));
//            System.out.println("t2:"+Integer.toBinaryString(t2));
//            System.out.println("t2>>1:" + Integer.toBinaryString(t2>>1));
//            System.out.println("t2:"+Integer.toBinaryString(t2));
            System.out.println(temp.isPowerOfTwo1(t));
        }
    }
}

class PowerofTwo{
    boolean isPowerOfTwo1(int n) {
        if (n==0) return false;
        while(n%2 == 0){
            n = n / 2;
        }
        return n == 1;
    }
    boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
    boolean isPowerOfTwo3(int n) {
        if (n==0) return false;
        int ones = 0;
        for (int i = 1; i <= 64; ++i) {
            ones += n & 1;//统计1的个数
            n = n >> 1;
        }
        return ones == 1;//只有一个1位正确结果
    }
    boolean isPowerOfTwo4(int n) {
        int shifts=(n==1)?0:1;
        for( int temp=n; (temp>>=1)>1; shifts++ );
        return n==(1<<shifts);
    }
}