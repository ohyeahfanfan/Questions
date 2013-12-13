package Recursive;
/*
 * Jump Game Total Accepted: 3190 Total Submissions: 11991 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*
* More detail requirement
* 
* as long as reach/pass the last index return true 
* [2,0] true
 * */
public class JumpGame {
	public boolean canJump(int[] A) {
        return recursive(A, 0);
    }
    public boolean recursive(int[] A, int index){
        if(index >= A.length - 1) return true;
        if(A[index] == 0) return false;
        return recursive(A, index + A[index]);
    }
}
