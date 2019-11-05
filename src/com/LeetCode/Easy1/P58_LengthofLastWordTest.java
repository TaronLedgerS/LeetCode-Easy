package com.LeetCode.Easy1;

public class P58_LengthofLastWordTest {
    public static void main(String[] args){
        LengthofLastWord temp = new LengthofLastWord();
        System.out.println(temp.lengthOfLastWord("Hello World"));
    }
}
class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i=s.length()-1; i>=0; i--) {//从字符串尾巴找起
            if(s.charAt(i) != ' ') {//定位到了最后一个单词
                while(i > -1 && s.charAt(i) != ' ') {//统计单词长度
                    count++;
                    i--;
                }
                break;//退出
            }
        }
        return count;
    }
}
