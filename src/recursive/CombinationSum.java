package Recursive;

import java.util.ArrayList;

import Math.RomanToInteger;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> rez = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		combinationSumHelper(candidates, target, 0, numbers, rez);
		return rez;
	}

	// combinations(n,target) = combination(n-1, target - n * a[n]) (
	// target/a[n] >= n >= 0)
	public void combinationSumHelper(int[] candidates, int target,
			int curIndex, ArrayList<Integer> numbers,
			ArrayList<ArrayList<Integer>> rez) {
		if (target == 0) {
			ArrayList<Integer> copy = new ArrayList<Integer>(numbers);
			rez.add(copy);
			return;
		}
		if (curIndex == candidates.length)
			return;
		int max = target / candidates[curIndex];
		for (int i = 0; i <= max; i++) {
			int sum = i * candidates[curIndex];
			combinationSumHelper(candidates, target - sum, curIndex + 1,
					numbers, rez);
			numbers.add(candidates[curIndex]);
		}
		for (int i = 0; i <= max; i++) {
			numbers.remove(numbers.size() - 1);
		}
	}
	 public static void main(String[] args) {
	  		// TODO Auto-generated method stub
		 CombinationSum obj = new CombinationSum();
		 int[] candidates = {2,3,6,7};
		 obj.combinationSum(candidates, 7);
	 }
}