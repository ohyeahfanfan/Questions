package DP;

import MergeOrAdd.AddBinary;

public class UniquePath {
	/*
	 * Unique Paths:
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
	 * (marked 'Finish' in the diagram below).
	 * How many possible unique paths are there?
	 * 
	 * Way(n,m) = Way(n-1, m) + Way(n, m-1);
	 */
	 public int uniquePaths(int m, int n) {
		 int[] dp = new int[m];
		 dp[0] = 1;
		 for(int i = 0; i < n; i++){
			 for(int j = 1; j < m ; j++){
				 dp[j] += dp[j-1]; 
			 }
		 }
		 return dp[m-1];
	 }
	 public static void main(String args[] ) {
		 UniquePath obj = new UniquePath();
	     System.out.println(obj.uniquePaths(3, 2));
	 }
	
}
