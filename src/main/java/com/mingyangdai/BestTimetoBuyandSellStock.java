package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/7/9
 */
public class BestTimetoBuyandSellStock {
	
	public static void main(String[] args) {
		int[] arrays = {7, 1, 5, 3, 6, 4};
		BestTimetoBuyandSellStock stock = new BestTimetoBuyandSellStock();
		int res = stock.maxProfit(arrays);
		System.out.println(res);
	}
	
	public int maxProfit2(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}
	
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		
		int min = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > profit) profit = prices[i] - min;
			}
		}
		return profit;
	}
	
}
