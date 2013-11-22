package DP;
/*
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */
public class MaxProfit {
	 public int maxProfit(int[] prices) {
	        int maxProfit = 0;
	        int min = Integer.MAX_VALUE;
	        for(int i = 0; i < prices.length; i++){
	            min = Math.min(min, prices[i]);
	            maxProfit = Math.max(maxProfit, prices[i] - min);
	        }
	        return maxProfit;
	    }
}
