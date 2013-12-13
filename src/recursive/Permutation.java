package Recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

	/*
	 * Permutations http://leetcode.com/onlinejudge#question_46 Given a
	 * collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * 
	 * 1. each position i, pick up one number [i+1, length-1] swap 2. repeat it
	 * for each position
	 */
	/*
	 * public ArrayList<ArrayList<Integer>> permute(int[] num) {
	 * ArrayList<ArrayList<Integer>> rez = new ArrayList<ArrayList<Integer>>();
	 * // start from position 0 permuteHelp(rez, 0, num); return rez; }
	 * 
	 * public void permuteHelp(ArrayList<ArrayList<Integer>> rez, int position,
	 * int[] num) { // base case if (position >= num.length - 1) {
	 * ArrayList<Integer> cur = new ArrayList<Integer>(); for (int i = 0; i <
	 * num.length; i++) { cur.add(num[i]); } rez.add(cur); return; } for (int i
	 * = position; i < num.length; i++) { swap(num, position, i);
	 * permuteHelp(rez, position + 1, num); swap(num, position, i); } return; }
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
	    ArrayList<ArrayList<Integer>> rez =new ArrayList<ArrayList<Integer>>();
	    permuteHelper(0, num, rez);
	    return rez;
    }

	public void permuteHelper(int curIndex, int[] num,
			ArrayList<ArrayList<Integer>> permutations) {
		if (curIndex == num.length - 1) {
			// how to copy array to array list
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++) {
				cur.add(num[i]);
			}
			permutations.add(cur);
			return;
		}

		for (int i = curIndex; i < num.length; i++) {
			swap(num, curIndex, i);
			permuteHelper(curIndex + 1, num, permutations);
			swap(num, curIndex, i);
		}
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();
		int[] testcase = { 1, 2, 3 };
		ArrayList <ArrayList<Integer>> rez = p.permute(testcase);
		System.out.println(rez.size());
	}

}
