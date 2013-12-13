package MergeOrAdd;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        while(n > 0){
            if(m > 0 && A[m-1] > B[n-1]){// A = [], B = [1] !!! m > 0
                A[m + n -1] = A[m - 1];
                m--;
            }else{
                A[m + n -1] = B[n - 1];
                n--;
            }
        }
    }
}
