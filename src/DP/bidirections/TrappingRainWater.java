package DP.bidirections;

/* @ Question:
 * Trapping Rain Water AC Rate: 475/1768 My Submissions
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @ submittion: 10/2/2013
 * 
 */
public class TrappingRainWater {
	/* 
	 * n time, constant space 
	 * 
	 * Two pointers, right and left
	 * left pointer initially set at the start position of the array
	 * right pointer initially set at the end position of the array
	 * 
	 * Two variables, leftMax and rightMax,
	 * the max values the left and right pointer meet so far
	 * 
	 * rain, the trapping rain water
	 * 
	 * The pointer, which points to smaller value, move first.
	 * eg. [0,1,0,2,1,0,1,3,2,1,2,1]
	 *    start                  end
	 * rain = 0, leftMax = 0, rightMax = 1  
	 *  
	 * left pointer move first, move until A[left] > A[right] 
	 * at each move, 
	 * keep updating leftMax 
	 * rain += leftMax - A[left]; 
	 * 
	 * eg. [0,1,0,2,1,0,1,3,2,1,2,1]
	 *        | |                 |
	 *        |start              | 
	 *      leftMax              end
	 *     (left bar)         (right bar)
	 * 
	 * eg. [0,1,0,2,1,0,1,3,2,1,2,1]
	 *            |           | |
	 *            |          end|
	 *          start          rightMax
	 *        (left bar)       (right bar)
	 *           
	 */
	public int trap1n(int[] A){
		int rain = 0;
		if(A == null || A.length == 0) return rain;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int left = 0;
		int right = A.length - 1;
		while(left < right){
			if(A[left] < A[right]){
				leftMax = Math.max(leftMax, A[left]);
				rain += leftMax -  A[left];
				left++;
			}else{
				rightMax = Math.max(rightMax, A[right]);
				rain += rightMax - A[right];
				right--;
			}
		}
		return rain;
	}
	/*
	 * 2n time , n space 
	 * 
	 */
	public int trap2n(int[] A) {
        int water = 0;
        if(A == null || A.length==0) return water;
        //1. for each bar, calculate the highest bar on its left side
        int[] leftMax = new int[A.length];
        leftMax[0] = A[0];
        for(int i = 1; i < A.length; i++){
            leftMax[i] = Math.max(A[i], leftMax[i-1]);
        }
        //2. for each bar, calculate the highest bar on its right side
        //3. calculate the trapping rain = min(leftMax, rightMax) - A[i]
        int rightMaxVal = A[A.length-1];
        for(int i = A.length -2; i >= 0; i--){
            rightMaxVal = Math.max(A[i], rightMaxVal);
            water += Math.min(leftMax[i], rightMaxVal) - A[i];
        }
        return water;
    }
	/*
	 * 3n time , 2n space 
	 * [0,1,0,2,1,0,1,3,2,1,2,1]
     * leftMax: [0,1,1,2,2,2,2,3,3,3,3,3]
     * rightMax:[3,3,3,3,3,3,3,3,2,2,2,1]
     * diff:    [0,0,1,0,1,2,1,0,0,1,0,0]
	 */
	public int trap3n(int[] A) {
        int water = 0;
        if(A == null || A.length==0) return water;
        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        leftMax[0] = A[0];
        for(int i = 1; i < A.length; i++){
            leftMax[i] = Math.max(A[i], leftMax[i-1]);
        }
        rightMax[A.length - 1] = A[A.length - 1];
        for(int i = A.length -2; i >= 0; i--){
            rightMax[i] = Math.max(A[i], rightMax[i+1]);
        }
        for(int i = 1; i < A.length-1; i++){
            water += Math.min(leftMax[i], rightMax[i]) - A[i];
        }
        return water;
    }
    
}
