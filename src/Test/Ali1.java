package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Ali1 {
    static int getAns(int n, int[] p) {
        //  没有人的情况下
        if (n == 0) return 0;
        //  有一个人时，返回这个人的时间
        if (n == 1) return p[0];
        //  有两个人时，返回用时较多的人的时间
        if (n == 2) return p[1];

        int[] dp = new int[n];
        dp[0]=p[0];
        dp[1]=p[1];
        /**
         * 人数多于2时，采用动态规划的思想，将问题拆分
         *  假设河的这一侧还剩一人，则派遣最快的人往返
         *  假设河的这一侧还剩二人，先派遣花费时间最少的人过来，
         *     待这两人走后，花费时间此少的人过来携带最少的人一同回去
         */
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1]+p[0]+p[i],dp[i-2]+p[0]+p[i]+2*p[1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        System.out.println(getAns(n,a));
    }
}
