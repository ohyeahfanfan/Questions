package Bit;

public class SingleNumber {
	/*
	 * Single Number AC Rate: 343/869 My Submissions
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 * Could you implement it without using extra memory?
	 * 
	 * A的边界 leetcode没有考虑
	 * 
	 */
	public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int num =  A[0];
        for(int i = 1;  i < A.length; i++){
            num ^= A[i];
        }
        return num;
    }
}
