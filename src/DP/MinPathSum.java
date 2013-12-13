package DP;

public class MinPathSum {
	 public int minPathSum(int[][] grid) {
			int[] dp = new int[grid[0].length];
	        for(int i = 0; i < grid.length; i++){
	        	for(int j = 0; j < grid[0].length; j++){
	                //first column 
	                if(j == 0){
	                    dp[j] = dp[j];
	                //first row        
	                }else if(i == 0){
	                    dp[j] = dp[j-1];    
	                }else{
	                    dp[j] = Math.min(dp[j-1], dp[j]);
	                }
	                dp[j] += grid[i][j];
	            }
	        }
	        return dp[dp.length-1]; 
	    }
}
