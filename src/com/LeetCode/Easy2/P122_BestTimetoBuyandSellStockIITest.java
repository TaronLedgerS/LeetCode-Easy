package com.LeetCode.Easy2;

import java.util.Arrays;

public class P122_BestTimetoBuyandSellStockIITest {
    public static  void main(String[] args) {
        BestTimetoBuyandSellStockII temp = new BestTimetoBuyandSellStockII();
        int[] nums = {7,1,5,3,6,4};
        System.out.println(nums.length);
        System.out.println(temp.maxProfit(nums));
        System.out.println(Arrays.toString(nums));
    }
}
class BestTimetoBuyandSellStockII {
    public int maxProfit(int prices[]) {

        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] >prices[i-1])
                maxprofit =maxprofit + prices[i] - prices[i-1];
        }
        return maxprofit;
    }
}