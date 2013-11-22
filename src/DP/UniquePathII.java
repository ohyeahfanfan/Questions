package DP;

public class UniquePathII {
	/*
	 * http://leetcode.com/onlinejudge#question_63
	 * CRC 9.3
	 * Unique Paths II
		Follow up for "Unique Paths":
		
		Now consider if some obstacles are added to the grids. How many unique paths would there be?
		
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
		
		For example,
		
		There is one obstacle in the middle of a 3x3 grid as illustrated below.
			 * 
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        //[[0]]
        dp[0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j]==1){
                    //[[1]]
                	dp[j] = 0;
                }else{
                	//[[0]]
                    if(j != 0){
                        dp[j] += dp[j-1];    
                    }
                            
                }
            }
        }
        return dp[dp.length-1];
    }
}
