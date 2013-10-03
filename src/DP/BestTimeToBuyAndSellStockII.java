package DP;

public class BestTimeToBuyAndSellStockII {
	   /* Best Time to Buy and Sell Stock II
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like 
     * (ie, buy one and sell one share of the stock multiple times). 
     * However, you may not engage in multiple transactions at the same time 
     * (ie, you must sell the stock before you buy again).
     * 
     * Solution:
     * !!!!!!!!!!!!!!!!!!!!!
     * MaxProfitSum(i) = MaxProfitSum(i-1) + max(0, price(i) - price(i-1))
     * MaxProfitSum(i): The max profit we can have from 0 to i position 
     * price(i): the price at i position
     */
    public int maxProfitIIBetter(int[] prices) {
        if(prices==null)return 0;
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            sum += Math.max(0, prices[i] - prices[i-1]);
        }
        return sum;
    }
}
