package BinarySearch;

public class SearchInsertPosition {
	  /***********Search Insert Position*********** 
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. 
    You may assume no duplicates in the array. 
      
    Here are few examples. 
    [1,3,5,6], 5 → 2 
    [1,3,5,6], 2 → 1 
    [1,3,5,6], 7 → 4 
    [1,3,5,6], 0 → 0 
   * 
   * Current problem assume no duplicates
   * The solution can solve more difficult question (with duplicates). 
   * If the input contains duplicates, the insert position is the position of first occurence of target
   * eg. 
   * [1,2,2,3] target 2
   * return index 1 
   * 
   */
public int searchInsert(int[] A, int target) { 
    int left = 0; 
    int right = A.length-1; 
    while(left <= right){
        int mid = left + (right - left)/2; 
        if(A[mid] < target){ 
            //if we use <= instead of <, when A[mid] == target, 
            //left will keep move right, if so left is not the 1st occurence
            left = mid + 1;  //[1] target 2
        }else{ 
            right = mid - 1; //[1] target 0/1
        } 
    } 
    return left;  
    //!!!! left不可能小于0，因为left一直是不断增加的, 
    //尽管left是随mid变化的， mid可能增大也可能减小，但是left始终是mid的下界限，所以始终left是增加的 
} 
	
}
