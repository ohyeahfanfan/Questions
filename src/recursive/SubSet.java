package Recursive;

import java.util.ArrayList;

/* @Source Leetcode & Crc 150 Charpter 9
 * http://leetcode.com/onlinejudge#question_78
 * 
 * @Problem
 * Subsets
 *	Given a set of distinct integers, S, return all possible subsets.
 *	
 *	Note:
 *	
 *	Elements in a subset must be in non-descending order.
 *	The solution set must not contain duplicate subsets.
 *	For example,
 *	If S = [1,2,3], a solution is:
 *	
 *	[
 *	  [3],
 *	  [1],
 *	  [2],
 *	  [1,2,3],
 *	  [1,3],
 *	  [2,3],
 *	  [1,2],
 *	  []
 *	] 
 * 
 * Recursion:
 * 
 * Subsets(S(n)) = Subsets(S(n-1)) U {Subsets(S(n-1)) with S(n) in each set}
 *     /    \
 *   [0]     []
 *   /  \    / \
 * [0] [0,1][] [1]
 * 
 * 1,2,3
 * 0,0,0 =>[]
 * 
 * 1,2,3
 * 1,0,0 =>[1]
 * 
 * 1,2,3
 * 0,1,0 =>[2]
 * 
 * 1,2,3 
 * 0,0,1 =>[3]
 * 
 * 1,2,3
 * 1,1,0 =>[1,2]
 * 
 * Feature:
 * 1. no duplicates in the elements
 * 2. calcuate set(combination instead of permutation)
 * 
 * Learn: shallow copy a list
 * [Better way]
 * ArrayList<Integer> copy = new ArrayList<Integer>(set);
 * 
 * Collections.copy()
 * java.lang.IndexOutOfBoundsException: Source does not fit in dest
 * The destination list must be at least as long as the source list. 
 * If it is longer, the remaining elements in the destination list are unaffected.
 * ArrayList<Integer> copy = new ArrayList<Integer>();
 * Collections.copy(copy, set);
 * 
 * 
  */
public class SubSet {
	 public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
	       ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> set = new ArrayList<Integer>();   
	       if(S == null) return sets;
	       subset(0, set, S, sets);
	       return sets;
	 }
	 public static void subset(int i, ArrayList<Integer> set, int[] S, ArrayList<ArrayList<Integer>> sets){
		 //Base case
		 if(i == S.length){
			 /*!!! java.lang.IndexOutOfBoundsException: Source does not fit in dest
			  * The destination list must be at least as long as the source list. 
			  * If it is longer, the remaining elements in the destination list are unaffected.
			  * ArrayList<Integer> copy = new ArrayList<Integer>();
			  * Collections.copy(copy, set);
			  */
			 ArrayList<Integer> copy = new ArrayList<Integer>(set);
			 sets.add(copy);
			 return;
		 }
		 //subsets do not contain element S[i]
		 subset(i+1, set, S, sets);
		 //subsets contain element S[i]
		 set.add(S[i]);
		 subset(i+1, set, S, sets);
		 set.remove(set.size()-1);
	 }
	 public static void main(String[] args) {
	 
	 }

}
