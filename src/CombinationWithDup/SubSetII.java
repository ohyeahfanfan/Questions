package CombinationWithDup;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetII {
	/* In mathematics, a set is a collection of distinct objects, no order
	 * combination: no order
	 * Set vs combination 
	 * In the question, the subset is not set
	 * 
	 * Idea:
	 * The question is similar to combination sum ii/2sum/3sum/4sum
	 * The input contains duplicate numbers. 
	 * Make sure the number with same value appear same position must be once.
	 * 
	 * eg [2,2,3,4] 3sum target 9
	 * we have [2,2,3], [2,3,4]
	 * All the first 2 should be 2 index = 0 otherwise in the result we will have
	 * two [2,3,4] 1st 2 is 1st 2/ 2nd 2
	 * 
	 * 
	 * 2sum, 3sum, 4sum require specified amount of numbers are contained in the result.
	 * Since this extra invariance, 
	 * the 2sum can be O(n) instead of O(n2)
	 * the 3sum can be O(n2) instead of O(n3)
	 * the 4sum can be O(n3) ideally it should be O(n2)
	 * 
	 * Compare to combination sum ii
	 * This questions is easier since it doesn't need to check if target is matched.
	 * The question with more constrains or invarience should find quicker solution.
	 * Since we can use the invarience
	 * 
	 * SubSet II > Combination Sum II ( 4 SUM > 3 SUM > 2 SUM)
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
	  *  2 2 2
	  *  1 0 0
	  *  and
	  *  2, 2, 2
	  *  0, 1, 0
	  *  and
	  *  2, 2, 2 
	  *  0, 0, 1
	  *  should be treated as one subset.
	  * 
	  *  similar as
	  *  2 2 2
	  *  1 1 0
	  *  
	  *  2 2 2
	  *  0 1 1
	  *  
	  *  2 2 2
	  *  1 0 1
	  *  
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
	/*
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
		
	}*/
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> subset = new ArrayList<Integer>();
	        subsetsWithDupHelper(num, 0, subset, set);
	        return set;
	    }
	// number with same value can only appear one position once.
	
	public void subsetsWithDupHelper(int[] num, int start, ArrayList<Integer> subset
	, ArrayList<ArrayList<Integer>> set){
	    if(start == num.length){
	        ArrayList<Integer> copy = new ArrayList<Integer>(subset);
	        set.add(copy);
	        return;
	    }
	    //len: number of number with same value
		//how many times the number can occur in the subset
		int lenOfSameVals = 1;
		while(start + lenOfSameVals < num.length && num[start] == num[start + lenOfSameVals] ){
		    lenOfSameVals ++;
		}
		// occur between 0 to len
	    for(int i = 0; i <= lenOfSameVals; i++){
	        subsetsWithDupHelper(num, start + lenOfSameVals, subset, set);
	        subset.add(num[start]);
	    }
	    for(int i = 0; i <= lenOfSameVals; i++){
	        subset.remove(subset.size()-1);
	    }
	}
}
