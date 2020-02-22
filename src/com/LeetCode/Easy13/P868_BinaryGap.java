package com.LeetCode.Easy13;

public class P868_BinaryGap {
    public int binaryGap(int N) {
        int gap,maxGap=0;
        int lastOne  = -1;
        while (N>0){
            if (N%2 == 1) {
                gap = lastOne +1;
                maxGap = Math.max(maxGap, gap);
                lastOne = 0;
            }
            if (N%2 == 0) {
                if (lastOne!=-1)
                    lastOne++;
            }
            N=N/2;
        }
        return maxGap;
    }
    public static void main(String[] args) {
        System.out.println(
                new P868_BinaryGap().binaryGap(11)
        );
    }
}
