package Recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetII {
	/* In mathematics, a set is a collection of distinct objects, no order
	 * combination: no order
	 * Set vs combination 
	 * In the question, the subset is not set
	 * 
	 * @Source Leetcode
	 * Subsets II 
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
	 * Note:
	 * Elements in a subset must be in non-descending order.
	 * The solution set must not contain duplicate subsets.
	 * For example,
	 * If S = [1,2,2], a solution is:
	 * [
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
		
	  * @Feature:
	  *  1. has duplicates
	  *  2. combination(not permutation)
	  * 
	  * @Solution
	  * Combination(n) = Combination(n-1) without num[n] 
	  * + Combination(n-1) with num[n] which before num[n] has same number of duplicates in num and combination 
	  *  
	  *  1,2,2,2
	  *  1[0-1],2[0-3]
	  *  
	  *  1,2
	  *  0,0=>[]
	  *  
	  *  1,2
	  *  0,1=>[2]
	  *  
	  *  1,2
	  *  0,2=>[2,2]
	  *  
	  *  1,2
	  *  0,3=>[2,2,2]
	  *   
	  */
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();
		Arrays.sort(num);
		subsetsWithDupHelper(0, num, comb, combs);
		return combs;
    }
	// number with same value can only appear one position once.
	public static void  subsetsWithDupHelper(int i, int[] num, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> combinations){
		if(i == num.length){
			ArrayList<Integer> copy = new ArrayList<Integer>(combination);
			combinations.add(copy);
			return;
		}
		//len: number of number with same value
		//how many times the number can occur in the subset
		int len  = 1;
		while(i+len < num.length && num[i+len]==num[i]){
			len++;
		}
		// occur between 0 to len
		for(int count = 0; count <= len; count++){
			subsetsWithDupHelper(i+len, num, combination, combinations);
			combination.add(num[i]);
		}
		for(int count = 0; count <= len; count++){
			combination.remove(combination.size()-1);
		}
		
	}
}
