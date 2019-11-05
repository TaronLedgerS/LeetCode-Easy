package com.LeetCode.Easy1;

public class P7_ReverseIntegerTest {
    public static void  main(String[] args){
        System.out.println(ReverseInteger.reverse(-1474836480));
    }
}
class ReverseInteger {
     static int reverse(int x) {
        int newx = 0;
        while (x != 0) {
            int temp = x % 10;//取余数
            x /= 10;//整除
            //防止向上溢出2147483647
            if (newx > Integer.MAX_VALUE / 10 || (newx == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            //防止向下溢出-2147483648
            if (newx < Integer.MIN_VALUE / 10 || (newx == Integer.MIN_VALUE / 10 && temp < -8)) return 0;
            newx = newx * 10 + temp;
        }
        return newx;
    }
}