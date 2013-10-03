package DP;
/* 
 * @Source
 * http://leetcode.com/onlinejudge#question_62
 * CRC 9.2
 * 
 * @Problem
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * f(x,y) = f(x-1, y) + f(y-1, x)
 * In (m+n) rounds, pick up m right move
 * (m+n)!/(m!*n!)
 * To make Combinatorial Solution work, we should optimize the factorial
 */

public class UniquePath {
	 public int uniquePaths(int m, int n) {
	        int[] matrix = new int[n];
	        matrix[0] = 1;
	        for(int i = 0; i < m; i++){
	            //j = 0 forever 0
	            for(int j = 1; j < n; j++){
	                // top + left
	                matrix[j] += matrix[j-1];
	            }    
	        }
	        return matrix[n-1];
	        
	    }
	 public int uniquePathsMinMNSpace(int m, int n) {
	        int innerBound = Math.min(m,n);
	        int outerBound = Math.max(m,n);
	        int[] dp = new int[innerBound];
	        dp[0] = 1;
	        for(int i = 0; i < outerBound; i++){
	            for(int j = 0; j < innerBound; j++){
	                if(i == 0 && j == 0) continue;
	                /*if(i-1 >= 0){
	                    dp[j] += [j];
	                }*/
	                if(j-1 >= 0){
	                    dp[j] += dp[j-1];
	                }
	            }
	        }
	        return dp[innerBound-1];
	    }
	//Overflow 100!
	//To make Combinatorial Solution work, we should optimize the factorial
	/*
	public int uniquePaths(int m, int n) {
        m = m -1;
        n= n-1;
        return (int)(factorial(m+n)/(factorial(m)*factorial(n)));
       
        
    }
    public long factorial(long n){
        if(n==1||n==0) return 1;
        return factorial(n-1)*n;
    }*/
	//f(x,y) = f(x-1. y) + f(x,y-1)
   
}
