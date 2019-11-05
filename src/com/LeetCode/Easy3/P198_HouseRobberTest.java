package com.LeetCode.Easy3;

public class P198_HouseRobberTest {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        HouseRobber temp= new HouseRobber();

        System.out.println(temp.rob1(nums));

        System.out.println(temp.rob2(nums));

    }

}
class HouseRobber{
    public int rob1(int[] num) {
        if (num==null|num.length==0) return 0;
        int[][] dp = new int[num.length][2];//分别记录前i个元素，能达到的最大和
        dp[0][0] = 0;//dp[i][0]表示不取当前这个数
        dp[0][1] = num[0];//dp[i][1]表示取当前这个数
        for (int i = 1; i < num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);//不取
            dp[i][1] = num[i] + dp[i - 1][0];//取
        }
        return Math.max(dp[num.length-1][0], dp[num.length-1][1]);
    }


    public int rob2(int[] num) {
        if (num==null|num.length==0) return 0;
        int preNo = 0;//表示若不取第i个整数，前i个整数的最大和
        int preYes = num[0];//表示若取第i个整数，前i个整数的最大和
        int temp = 0;
        for (int i = 1; i < num.length; i++) {
            temp = preNo;
            preNo = Math.max(temp,preYes);//不取
            preYes = num[i] + temp;//取
        }
        return Math.max(preNo,preYes);
    }
}