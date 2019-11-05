package com.LeetCode.Easy2;

public class P125_ValidPalindromeTest {
    public static  void main(String[] args) {
        ValidPalindrome temp = new ValidPalindrome();
        System.out.println(temp.isPalindrome1( "A man, a plan, a canal: Panama"));
        System.out.println(temp.isPalindrome2( "A man, a plan, a canal: Panama"));
    }
}
class ValidPalindrome {
     boolean isPalindrome1(String s) {
         //replaceAll() 方法使用给定的参数 replacement 替换字符串所有匹配给定的正则表达式的子字符串。
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();//去掉除字母数字意外的字符
        //System.out.println(actual);
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
     boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {//逐一比较
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
