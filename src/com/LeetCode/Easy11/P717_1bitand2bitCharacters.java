package com.LeetCode.Easy11;


public class P717_1bitand2bitCharacters  {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i]==0) i++;
            else i += 2;
        }
        return i==bits.length-1;
    }
    public static void main(String[] args){
        System.out.println(
                new P717_1bitand2bitCharacters().isOneBitCharacter(
                        new int[]{1,1,0}
                )
        );
    }
}
