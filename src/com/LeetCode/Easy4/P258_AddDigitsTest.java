package com.LeetCode.Easy4;

public class P258_AddDigitsTest {
    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(38));
    }
}
class AddDigits{
    public int addDigits(int num) {
        int ans = 0;
        while (true) {
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            if (ans >= 10) {
                num = ans;
                ans = 0;
            } else
                return ans;
        }

    }
}
