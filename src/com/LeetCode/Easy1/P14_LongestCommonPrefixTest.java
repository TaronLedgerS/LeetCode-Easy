package com.LeetCode.Easy1;

public class P14_LongestCommonPrefixTest {
    public static void main(String[] args){
        String[] s=new String[]{"flower","flow","flight"};
        System.out.println(LCP.longestCommonPrefix(s));
        System.out.println('\u0041');
    }
}
class LCP {
    static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length && pre.length()>0 ){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
