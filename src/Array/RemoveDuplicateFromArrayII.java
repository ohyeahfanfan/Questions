package Array;

public class RemoveDuplicateFromArrayII {
	/* Remove Duplicates from Sorted Array II 
	 * Follow up for "Remove Duplicates":
	 * What if duplicates are allowed at most twice?
	 * For example,
	 * Given sorted array A = [1,1,1,2,2,3],
	 * Your function should return length = 5, and A is now [1,1,2,2,3].*/
	public int removeDuplicates(int[] A) {
        int tail = 0;
        if(A == null||A.length == 0) return 0;
        for(int i = 1; i < A.length; i++){
        	//not same or same but not same with one element ahead
            if(A[tail] != A[i] || tail-1 < 0 || A[tail-1] != A[i]){
                A[++tail] = A[i];
            }
        }
        return tail+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
