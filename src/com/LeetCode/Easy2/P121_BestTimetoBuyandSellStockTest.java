package com.LeetCode.Easy2;

import java.util.Arrays;

public class P121_BestTimetoBuyandSellStockTest{
    public static  void main(String[] args) {
        BestTimetoBuyandSellStock temp = new BestTimetoBuyandSellStock();
        int[] nums = {7,1,5,3,6,4};
        System.out.println(nums.length);
        System.out.println(temp.maxProfit(nums));
        System.out.println(Arrays.toString(nums));
    }
}
 class BestTimetoBuyandSellStock {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}