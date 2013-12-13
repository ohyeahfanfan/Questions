package BinarySearch;
/*
 * Search in Rotated Sorted Array Total 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array. 
 * 
 * Idea:
 * 
 * 
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(A[mid] == target) return mid;
            if(A[left] <= A[mid]){
                if(A[left] <= target && target < A[mid]){
                    // A[left] < target < A[mid]
                    // then, go left
                    right = mid - 1;
                }else{
                    // then, go right
                    left = mid + 1;
                }
            }else{
                if(A[right] >= target && target > A[mid]){
                    // A[mid] < target < A[right]
                    // then go right;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
