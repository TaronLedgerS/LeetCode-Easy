package com.LeetCode.Easy13;

public class P914_XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10001];
        for(int a :deck)
            count[a]++;

        int gcd = -1;
        for(int a: count){
            if(a>0){
                if(gcd==-1)
                    gcd = a;
                else
                    gcd = getGCD(gcd,a);
            }
        }
        return gcd>=2;
    }
    //最大公约数！！！
    public int getGCD(int x,int y){
        if(y==0)
            return x;
        return getGCD(y,x%y);
    }
}
