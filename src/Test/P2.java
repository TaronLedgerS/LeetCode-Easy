package Test;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] a = new Integer[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            a[i] = in.nextInt();
        }
        long ans = 0;
        Arrays.sort(a,(o1,o2)->(o2-o1));
        for (int i = 0; i < n; i++) {
            ans += a[2*i+1];
        }
        System.out.println(ans);
    }
}
