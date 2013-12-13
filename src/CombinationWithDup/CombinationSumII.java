package CombinationWithDup;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 ??? a2 ??? ??? ??? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * Idea:
 * The question is similar to subsetII/2sum/3sum/4sum
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
 * 
 */
public class CombinationSumII {
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> combination = new ArrayList<Integer>();
		    combinationSum2Helper(num, target, 0, combination, combinations);
		    return combinations;
	    }
	    public void combinationSum2Helper(int[] num, int target, int start, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> combinations){
	        //base case 1: we find the combination the sum is target
	    	if(target == 0){
	            ArrayList<Integer> copy = new ArrayList<Integer>(combination);
		        combinations.add(copy);
		        return;
	        }
	    	//base case 2: run out of index
	        if(start >= num.length) return;
	        //base case 3: larger than target, since we have the constrain all numbers are positive
	        if(target < num[start]) return;
	        
	        int lenOfSameVals = 1;
	        //lenOfSameVals: number of number with same value
			//how many times the number can occur in the subset
			while(start + lenOfSameVals < num.length && num[start] == num[start + lenOfSameVals] ){
			    lenOfSameVals ++;
			}
			// occur between 0 to len
		    for(int i = 0; i <= lenOfSameVals; i++){
		        combinationSum2Helper(num,  target - i * num[start], start + lenOfSameVals,combination, combinations);
		        combination.add(num[start]);
		    }
		    for(int i = 0; i <= lenOfSameVals; i++){
		        combination.remove(combination.size()-1);
		    }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII obj = new CombinationSumII();
		int[] arr = {10,1,2,7,6,1,5};
		ArrayList<ArrayList<Integer>> rez = obj.combinationSum2(arr, 8);
		System.out.println(rez.size());
	}

}
