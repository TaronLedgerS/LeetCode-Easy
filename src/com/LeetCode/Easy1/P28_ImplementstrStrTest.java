package com.LeetCode.Easy1;


public class P28_ImplementstrStrTest {
    public static void main(String[] args){
        ImplementstrStr temp = new ImplementstrStr();

        System.out.println(temp.strStr1("ababbabbcc","ababbcc"));
        System.out.println(temp.strStr1("hello","ll"));
        System.out.println(temp.strStr1("hello",""));
        System.out.println(temp.strStrKMP("ababbabbcc","ababbcc"));
        System.out.println(temp.strStrKMP("hello","ll"));
        System.out.println(temp.strStrKMP("hello",""));

    }
}
class ImplementstrStr {
    int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {//枚举haystack匹配的第一个位置
            for (int j = 0; ; j++) {//枚举已经匹配的子串字符个数
                if (j == needle.length()) return i;//子串字符完全匹配，返回匹配起始位置i
                if (i + j == haystack.length()) return -1;//未匹配结束但haystack已到结尾
                if (needle.charAt(j) != haystack.charAt(i + j)) break;//匹配错误，枚举下一个位置
            }
        }
    }
    int strStrKMP(String haystack, String needle) {
            //KMP algorithms
            if(needle.equals("")) return 0;
            if(haystack.equals("")) return 0;
            char[] arr = needle.toCharArray();
            int[] next = makeNext(arr);

            for(int i = 0, j = 0, end = haystack.length(); i < end;){
                if(j == -1 || haystack.charAt(i) == arr[j]){
                    j++; i++;
                    if(j == arr.length)//匹配到了
                        return i - arr.length;
                }
                if(i < end && haystack.charAt(i) != arr[j]) j = next[j]; //每匹配到，回退
            }
            return -1;
        }

        private int[] makeNext(char[] arr){
            int len = arr.length;
            int[] next = new int[len];
            next[0] = -1;
            for(int j = 0, k = -1; j + 1 < len;){
                if(k == -1 || arr[j] == arr[k]){
                    j++;
                    k++;
                    next[j] = next[k];
                }else{
                    k = next[k];
                }
            }
            return next;
        }

}



