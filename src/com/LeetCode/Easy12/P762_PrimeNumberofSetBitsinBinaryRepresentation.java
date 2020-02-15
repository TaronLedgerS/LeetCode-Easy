package com.LeetCode.Easy12;

public class P762_PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int ans =0;
        for (int i = L; i <= R; i++) {
            int count = Integer.bitCount(i);
            if (count==2||count==3||count==5||count==7||count==11||count==13||count==17||count==19)
                ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P762_PrimeNumberofSetBitsinBinaryRepresentation().countPrimeSetBits(2, 21)
        );
    }
}
