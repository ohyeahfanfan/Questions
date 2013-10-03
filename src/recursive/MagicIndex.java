package Recursive;

import java.util.ArrayList;

public class MagicIndex {

	/**
	 * A magic index in array A[0...n-1] is defined to be an index such that A[i] = i. Given a sorted array, write a method to find a magic index, if one exists, in array A.
	 *	FOLLOW UP
	 *	What if values are not distinct?
	 *
	 *	Solution: Complexity - O(log(n))
 	 *  for each position
 	 *  we have three cases
 	 *  1. A[i] == i 
 	 *     go right until A[i] != i
 	 *     go left until A[i] != i
 	 *  2. A[i] < i go right
 	 *  3. A[i] > i go left
 	 *  
 	 *  Test Case:
 	 *  1. []   []
 	 *  2. [0]  [0] case 1
 	 *  3. [-1] [] case 2
 	 *  4. [1]  [] case 3
 	 *  5. [0,1] [0, 1] case 1
 	 *  6. [0,1,2] [0,1,2] case 1
 	 *  7. [-1,1,3] [3] case 2
 	 *  8. [0,5,6] [0] case 3
 	 *  
 	 *  Datetime: Jun 27 7:52
 	 */
	public void getMagicIndexNoDup(int[] arr, int start, int end, ArrayList<Integer> magicIndice){
		if(arr == null || arr.length ==0 || start > end) return;
		int mid = start + (end - start)/2;
		//base case
		if(arr[mid] == mid){
			magicIndice.add(mid);
			for(int i = mid + 1; i <= end && i == arr[i]; i++){
				magicIndice.add(i);
			}
			for(int i = mid - 1; i >= start && i == arr[i]; i--){
				magicIndice.add(i);
			}
		}else if(arr[mid] < mid){
			getMagicIndexNoDup(arr, mid+1, end, magicIndice);
		}else{
			getMagicIndexNoDup(arr, start, mid-1, magicIndice);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicIndex mi = new MagicIndex();
		int[] arr = {};
		ArrayList<Integer> magicIndice = new ArrayList<Integer>();
		mi.getMagicIndexNoDup(arr, 0, arr.length, magicIndice);
	}

}
