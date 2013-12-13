package DP;

import Tree.RecoverBST;
import Tree.TreeNode;

public class UniqueBST {
	/*
	 * f(n) = f(0)f(n-1) + f(1)f(n-2) + ... + f(n-2)f(1) + f(n-1)f(0) 
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 * For example,
	 * Given n = 3, there are a total of 5 unique BST's.
	 */
	public int numTrees(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for(int i = 2 ; i <= n; i++){
    	   for(int j = 0; j <= i-1; j++){
    		   dp[i] += dp[j] * dp[i-1-j];
    	   }
       }
       return dp[n];
    }
	public static void main(String[] args) {
		UniqueBST obj = new UniqueBST();
		System.out.println(obj.numTrees(5));
	}
}
