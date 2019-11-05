package com.LeetCode.Easy4;

public class P205_IsomorphicStringsTest {
    public static void main(String[] args) {
        IsomorphicString temp = new IsomorphicString();
        System.out.println(temp.isIsomorphic("abbcc","deeff"));
    }
}

class IsomorphicString{
    public boolean isIsomorphic(String s1, String s2) {
        int[] lastS1 = new int[256];
        int[] lastS2 = new int[256];
        //初始出现均属于同构，两个数组初始化为0
        for (int i = 0; i < s1.length(); i++) {
            //判断当前位置上这一对字母映射上一次出现的位置是否相同
            if (lastS1[s1.charAt(i)] != lastS2[s2.charAt(i)])
                return false;
            //相同则，更新最新位置信息
            lastS1[s1.charAt(i)] = lastS2[s2.charAt(i)] = i+1;
        }
        return true;
    }
}
