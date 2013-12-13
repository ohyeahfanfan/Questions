package BinarySearch;
/*
 * Search in Rotated Sorted Array II Total Accepted: 2282 Total Submissions: 7934 My Submissions
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * 
 * 
 */
public class SearchInRotatedSortedArrayWithDuplicate {
	 public boolean search(int[] A, int target) {
	        int left = 0; 
	        int right = A.length-1;//!!!!!!Array check index before access 
	          
	        while(left <= right){ 
	            int mid = left+(right-left)/2;//!!!! avoid overflow 
	            if(A[mid]==target) return true; 
	            //if the bottom half is in  increase order 
	            if(A[left] < A[mid]){ 
	                if(A[left] <= target && target < A[mid]){// target is in the bottom half range 
	                    right = mid - 1; 
	                }else{ 
	                    left = mid + 1; 
	                } 
	            }else if(A[mid]<A[right]){//else the upper half is in  increase order 
	                if(A[right] >= target && target > A[mid]){//target is in the upper half range 
	                    left = mid + 1; 
	                }else{ 
	                    right = mid - 1; 
	                } 
	              
	            }else{//reduce to O(n)1111122221113111 
	                while(left<A.length){ 
	                    if(A[left]==target){ 
	                        return true; 
	                    } 
	                    left++; 
	                } 
	                return false; 
	            } 
	        } 
	        return false; 
	    }
}
