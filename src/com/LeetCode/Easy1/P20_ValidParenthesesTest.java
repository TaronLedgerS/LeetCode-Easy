package com.LeetCode.Easy1;

import java.util.HashMap;
import java.util.Stack;

public class P20_ValidParenthesesTest {
    public static void main(String[] args){
        ValidParentheses temp = new ValidParentheses();
        System.out.println(temp.isValid("()[]{}"));
        System.out.println(temp.isValid("()[{}"));
    }
}
class ValidParentheses{
    //建立括号匹配列表
    private HashMap<Character,Character> ParentheseMap;
    {
        ParentheseMap = new HashMap<Character, Character>();
        ParentheseMap.put(')','(');
        ParentheseMap.put(']','[');
        ParentheseMap.put('}','{');
    }
    boolean isValid(String s) {
        Stack<Character> aStack = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(ParentheseMap.containsKey(c)){//判断是否为右括号
                if(aStack.empty()) {//右括号且栈为空，则不合法
                    return false;
                }else{
                    char topElement = aStack.pop();
                    if (topElement!=ParentheseMap.get(c)){//匹配失败
                        return false;
                    }
                }
            }else{//字符为左括号压入
                aStack.push(c);
            }
        }
        return aStack.empty();
    }
}