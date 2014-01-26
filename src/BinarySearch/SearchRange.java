package BinarySearch;

public class SearchRange {
	/*
	 * Search for a Range
	 * Given a sorted array of integers, find the starting and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return [-1, -1].
	 * For example:
	 * Given [5, 7, 7, 8, 8, 10] and target value 8,
	 * return [3, 4].
	 * 
	 * The problem can be reduced to search insert position which input cantain duplicates
	 * 1. find the 1st occurrence of target start 
	 * 2. find the 1st occurrence of target + 1, the end position just need - 1
	 * 
	 */
	public int[] searchRange(int[] A, int target) {
        int[] rez = {-1, -1};
        int start = searchInsertPos(A, target);
        if(start == A.length || A[start] != target) return rez;
        rez[0] = start;
        rez[1] = searchInsertPos(A,target+1) - 1;
        return rez;
    }
    public int searchInsertPos(int[] A, int target){
        int left = 0; 
        int right = A.length-1; 
        while(left <= right){ 
            int mid = left + (right - left)/2; 
            if(A[mid] < target){ 
                left = mid + 1; 
            }else{ 
                right = mid - 1; 
            } 
        } 
        return left;
    }
    public static void main(String[] args) {
    	int[] A = {5, 7, 7, 8, 8, 10}; 
    	int target = 10;
    	SearchRange obj = new SearchRange();
    	int[] rez = obj.searchRange(A, target);
    	System.out.println(rez[0]);
    	System.out.println(rez[1]);
	}
}
