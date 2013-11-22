package DP;
/*
 * Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class MaxProfitIII {
	 // maxprofit(i,j) + maxprofit(j + 1, n)
    //ºÜÏñ3sum complete£¬3´Î O(n^2), 4´Î O(n^2)
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices == null || prices.length < 2) return 0;
        int min = prices[0];//!!!!!!!
        int max = prices[prices.length - 1];//!!!!!!!!!!!!!
        int maxProfit = 0;
        int[] maxSells = new int[prices.length];
        int[] minBuys = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxSells[i] = Math.max(prices[i] - min, maxSells[i-1]);//!!!!!!!!!!!!!
        }
        
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            //minBuys[i] = max - prices[i];
            minBuys[i] = Math.max(max - prices[i], minBuys[i+1]);
        }
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, maxSells[i] + minBuys[i]);
        }
        return maxProfit;
    }
}
