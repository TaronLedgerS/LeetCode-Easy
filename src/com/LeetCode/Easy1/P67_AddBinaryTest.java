package com.LeetCode.Easy1;

public class P67_AddBinaryTest {
    public static void main(String[] args){
       AddBinary temp = new AddBinary();
        System.out.println(temp.addBinary("1001", "111"));
    }
}
class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();//低位在前高位在后
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;//记录进位
        while(i>=0||j>=0){
            //相加
            int sum = carry;
            if(j>=0){
                sum = sum + b.charAt(j)-'0';
                j--;
            }
            if(i>=0){
                sum = sum + a.charAt(i)-'0';
                i--;
            }
            ans.append(sum%2);
            carry = sum/2;
        }
        if (carry != 0) ans.append(carry);
        return ans.reverse().toString(); //反转过来并更换数据类型
    }
}