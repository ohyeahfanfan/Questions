package Recursive;

import java.util.ArrayList;

/*  
 *  @problem
 *  Combinations
 *	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *	
 *	For example,
 *	If n = 4 and k = 2, a solution is:
	
 *	[
 *	  [2,4],
 *	  [3,4],
 *	  [2,3],
 *	  [1,2],
 *	  [1,3],
 *	  [1,4],
 *	]
 *  
 *  Features:
 *  1. No duplicate
 *  2. Set (combination)
 *  
 *  Recursion
 *  from 1 to i pick up k, can be solved by 
 *  Subset(i, k) = Subset(i-1, k-1) with S[i] 
 *  				+ Subset(i-1, k) without S[i] (1 <= i <= n)
 *  Subset(i,n,k) = Subset(i+1, n, k-1) with S[i]
 *  				+ Subset(i+1, n, k) without S[i]
 *  Say we have 1, 2, 3 (n = 3) pick up 2 (k = 2)
 *  we can do pick up 1 + from 2,3 pick up 1 element
 *  or not pick up 1 + from 2,3 pick up 2 elements
 *   
 */
public class Combination {
	/*
	 * Test Case:
	 * n = 0
	 * n = 1 k = 0 
	 * n = 1 k = 1
	 * n = 2 k = 1
	 */
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
	      ArrayList<Integer> set = new ArrayList<Integer>();
	      if(n <= 0 || k < 0) return sets;
	      int i = 1;
	      pickKfromN(i, k, n, set, sets);
	      return sets;
	 }
	 public void pickKfromN(int i, int k, int n, ArrayList<Integer> set, ArrayList<ArrayList<Integer>> sets){
		 //base case 1: !! we have enough elements 
		 if(0 == k){
			 ArrayList<Integer> copy = new ArrayList<Integer>(set);
			 sets.add(copy);
			 return;
		 }
		 //base case 2: run out of boundary
		 if(i == n + 1) return;
		 pickKfromN(i+1, k, n, set, sets);
		 set.add(i);
		 pickKfromN(i+1, k-1, n, set, sets);
		 set.remove(set.size()-1);
	}
}
