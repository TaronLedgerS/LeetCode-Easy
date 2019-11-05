package com.LeetCode.Easy3;

public class P204_CountPrimesTest {
    public static void main(String[] args) {
        CountPrimes temp = new CountPrimes();
        System.out.println(temp.countPrimes(10));
    }
}
class CountPrimes{

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}