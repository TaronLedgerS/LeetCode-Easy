package com.LeetCode.Easy15;

public class P1013_PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int allSum = 0;
        for (int a : A) allSum += a;
        if (allSum % 3 != 0) return false;
        int numOfPart = 0;
        int curSum = 0;
        allSum /= 3;
        for (int i = 0;i<A.length;i++) {
            curSum += A[i];
            if (allSum == curSum) {
                numOfPart++;
                curSum = 0;
            }
        }
        return numOfPart >= 3;
    }

    public static void main(String[] args) {
        System.out.println(new P1013_PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSum(
                new int[]{1, -1, 1, -1}
        ));
    }
}
