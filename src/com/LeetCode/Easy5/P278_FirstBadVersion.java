package com.LeetCode.Easy5;

import java.util.Scanner;

public class P278_FirstBadVersion {
    //0代表bad
    private int[] versions;

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left<right){
            int mid =left+ (right-left)/2;
            if (isBadVersion(mid)) {
                right = (int)mid;
            } else {
                left = (int)mid+1;
            }
        }
        return  left;
    }

    private boolean isBadVersion(int mid) {
        return versions[mid] == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = n+m;
        System.out.println(n+m);
        System.out.println(t);
        P278_FirstBadVersion test = new P278_FirstBadVersion();
        test.versions = new int[n];
        for (int i = 1; i <=m; i++) {
            test.versions[i] = 1;
        }
        System.out.println(test.firstBadVersion(n));
    }

}
