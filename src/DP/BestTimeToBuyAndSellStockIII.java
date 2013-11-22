package DP;

public class BestTimeToBuyAndSellStockIII {
	   /*
	    * http://leetcode.com/onlinejudge#question_123
	    * Best Time To Buy And Sell Stock III
	    * Say you have an array for which the ith element is the price of a given stock on day i.
        * Design an algorithm to find the maximum profit. You may complete at most two transactions.
        * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
        * Solution
	    * MaxProfitTwoTrans(0,n-1) = Max(MaxProfitOneTran(0,i) + MaxProfitOneTran(i+1,n-1))
	    */
	    public int maxProfit(int[] prices) {
	        if(prices == null || prices.length == 0) return 0; 
	        int[] buyProfit = new int[prices.length];
	        int[] sellProfit = new int[prices.length];
	        int min = Integer.MAX_VALUE;
	        for(int i = 0;  i < prices.length; i++){
	            if(prices[i] < min){
	                min = prices[i];
	            }
	            if(i==0){
	                sellProfit[i] = prices[i] - min;
	            }else{
	                sellProfit[i] = Math.max(sellProfit[i-1], prices[i] - min);
	            }        
	        }
	        int max = Integer.MIN_VALUE;
	        for(int i = prices.length-1;  i >= 0; i--){
	            if(prices[i] > max){
	                max = prices[i];
	            }
	            if(i==prices.length-1){
	                buyProfit[i] =  max-prices[i];
	            }else{
	                buyProfit[i] = Math.max(buyProfit[i + 1], max-prices[i]);
	            }
	        }
	        int maxProfit = Integer.MIN_VALUE;
	        for(int i = 0; i < prices.length; i++){
	            maxProfit = Math.max(maxProfit, buyProfit[i] + sellProfit[i]);
	        }
	        return maxProfit;
	    }
}
