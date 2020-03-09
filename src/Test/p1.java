package Test;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n==1) {
            System.out.println(1);
            return;
        }
        int count= 1;
        int pre = in.nextInt();
        int flag = 0;
        for (int i = 1; i < n; i++) {
            int curr = in.nextInt();
            if (flag==0){
                if (curr>pre) flag=1;
                if (curr<pre)flag = -1;
                if(curr==pre) {
                    flag = 0;
                    continue;
                }
            }
            if (curr>=pre && flag>0) {
                pre = curr;
                continue;
            }
            if (curr<=pre && flag<0){
                pre = curr;
                continue;
            }
            count++;
            flag = 0;
            pre = curr;
        }
        System.out.println(count);
    }
}
