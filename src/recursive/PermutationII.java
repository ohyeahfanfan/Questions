package Recursive;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutationII {

	/**
	 *  http://leetcode.com/onlinejudge#question_47
	 *  Permutations II
	 *	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
		
	 *	For example,
	 *	[1,1,2] have the following unique permutations:
	 *	[1,1,2], [1,2,1], and [2,1,1].
	 *  
	 *  Cases need to be considered:
	 *  1. no swap between same number
	 *  2. only swap first 1 and 2, no swap between second 1 and 2 (I didn't consider this case)
	 *  Therefore,
	 *  One position
	 *  !!each unique number was placed only once!!
	 *  每个val在每个位置只能被选一次
     *   相同val之前的相对位置不变
     *    0,1,2,1
     *    当我们需要最后一个1和第一个0swap的时候
     *    第一个1已然swap过了
     *    对于位置0的进行的swap是从左向右开始的
	 *  
	 *  Solution:
	 *  We can have a noSwap function to check if this number has been placed in current position.
	 *  
	 *  Test Case: (Always start from the basic one)
	 *  1. null
	 *  2. 1
	 *  3. 1,2
	 *  4. 1,1
	 *  5. 1,2,3
	 *  6. 1,2,2
	 *  7. 1,1,2,2
	 *  
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(num == null) return null;
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        permute(0, num, permutations);
        return permutations;
    }
	public void permute_(int pos, int[] num, ArrayList<ArrayList<Integer>>  permutations){
		//base case if current pos is the last element in the array;
		if(pos == num.length - 1){
			ArrayList<Integer> permutation = new ArrayList<Integer>();
			for(int i = 0; i < num.length; i++){
				permutation.add(num[i]);
			}
			permutations.add(permutation);
			return;
		}
		for(int i = pos; i < num.length; i++ ){
			if(noSwap(pos, i, num)){
				continue;
			}
			swap(pos, i, num);
			permute(pos+1, num, permutations);
			//swap back, make sure every unique number after pos has been selected
			swap(pos, i, num);
		}
		return;
		
	}
	public void permute(int pos, int[] num, ArrayList<ArrayList<Integer>>  permutations){
		//base case if current pos is the last element in the array;
		if(pos == num.length - 1){
			ArrayList<Integer> permutation = new ArrayList<Integer>();
			for(int i = 0; i < num.length; i++){
				permutation.add(num[i]);
			}
			permutations.add(permutation);
			return;
		}
		HashSet<Integer> dict = new HashSet<Integer>();
		for(int i = pos; i < num.length; i++ ){
			//use space to get time
			if(dict.contains(num[i])) 
		        continue;
		    else 
		        dict.add(num[i]);
			swap(pos, i, num);
			permute(pos+1, num, permutations);
			//swap back, make sure every unique number after pos has been selected
			swap(pos, i, num);
		}
		return;
		
	}
	public void swap(int i, int j, int[] num){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	/*
	 * Function noSwap:
	 * determines whether we should swap the number in target and the number in source
	 * The number sits in the source num[source] shouldn't occur in the array num before. The range is [target, source - 1]
	 * 
	 * 1, 1, 2
	 * 
	 */
	public boolean noSwap(int target, int source, int[] num){
		//if target == source, return true
		for(int i = target; i < source; i++){
			if(num[i] == num[source]){
				//Same value has been placed into target before, 
				//so we don't need to swap num[source] to position target
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
