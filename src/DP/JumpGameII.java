package DP;
/*
Jump Game II Total Accepted: 2564 Total Submissions: 11305 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * */
public class JumpGameII {
	//Greedy
    public int jump(int[] A) {
        int[] jumps = new int[A.length]; 
           if(A.length==0||A[0]==0) return 0; 
           //2,3,1,1,4
           //0,0,0,0,0
           for(int i = 1; i<A.length; i++){ 
               jumps[i] = Integer.MAX_VALUE; 
               //2,3,1,1,4
               //0,1,0,0,0
               //2,3,1,1,4
               //0,1,1,0,0
               //每次都从最远开始
               for(int j = 0; j < i;j++){ 
                   if(i <= j + A[j]){ 
                       jumps[i] = jumps[j]+1; 
                       break; 
                   } 
                 
               } 
                 
           } 
           return jumps[A.length-1]; 
             
    }
	public static void main(String[] args) {
		int[] A = {2,1};
		JumpGameII obj = new JumpGameII();
		System.out.println(obj.jump(A));
	}
}
