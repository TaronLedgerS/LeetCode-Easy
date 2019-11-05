package com.LeetCode.Easy1;

public class P9_PalindromeNumberTest {
    public static void  main(String[] args){
        System.out.println(PalindromeNumber.isPalindrome1(-121));
        System.out.println(PalindromeNumber.isPalindrome1(121));
        System.out.println(PalindromeNumber.isPalindrome2(-121));
        System.out.println(PalindromeNumber.isPalindrome2(121));
    }
}
class PalindromeNumber{

    static boolean isPalindrome1(int x) {
        try{
            if(x<0) return false;
            String res = new StringBuilder(String.valueOf(x)).reverse().toString();
            return Integer.parseInt(res)==x ;
        } catch(Exception e) {
            return false;
        }
    }
    static boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
