package CombinationWithDup;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 4Sum Total Accepted: 2268 Total Submissions: 10575 My Submissions
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ??? b ??? c ??? d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * 
 Idea:
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
 * */
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		if(num == null) return combinations;
		Arrays.sort(num);;
		for(int n1 = 0; n1 < num.length - 3; n1 ++){
			if(n1 != 0 && num[n1] == num[n1 - 1]) continue;
			for(int n2 = n1 + 1; n2 < num.length - 2; n2 ++){
				if(n2 != n1 + 1 && num[n2] == num[n2 - 1]) continue;
				int n3 = n2 + 1;
				int n4 = num.length - 1;
				int preN3Index = -1;
				while(n3 < n4){
					int sum = num[n1] + num[n2] + num[n3] + num[n4];
					if(sum == target){
						if(preN3Index == -1 || num[preN3Index] != num[n3]){
							ArrayList<Integer> combination = new ArrayList<Integer>();
							combination.add(num[n1]);
							combination.add(num[n2]);
							combination.add(num[n3]);
							combination.add(num[n4]);
							combinations.add(combination);
							preN3Index = n3;
						}
						n3 ++;
						n4 --;
					}else if(sum < target){
						n3 ++;
					}else{
						n4 --;
					}
				}
			}
		}
		return combinations;
    }
	public static void main(String[] args) {
		FourSum obj = new FourSum();
		int[] abc = {1,1,1,2,2,3,3,4,4};
    	ArrayList<ArrayList<Integer>> rez = obj.fourSum(abc, 10);
    	System.out.println(rez.size());
    }
}
