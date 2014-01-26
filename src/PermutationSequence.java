
public class PermutationSequence {
	/* Permutation Sequence 
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.
	 * By listing and labeling all of the permutations in order,
	 * We get the following sequence (ie, for n = 3):
	 * "123"
	 * "132"
	 * "213"
	 * "231"
	 * "312"
	 * "321"
	 * Given n and k, return the kth permutation sequence.
	 * Note: Given n will be between 1 and 9 inclusive.
	 * 
	 * 4!
	 */
	public String getPermutation(int n, int k) {
		k = k - 1;
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++){
            sb.append(i);
        }
        StringBuffer rez = new StringBuffer();
        //calculate permutation
        for(int i = n - 1; i >= 0; i--){
            int factor = factorial(i);
            int index = k / factor;
            rez.append(sb.charAt(index));
            sb.deleteCharAt(index);
            k %= factor; 
        }
        return rez.toString();
    }
    public int factorial(int n){
        int rez = 1;
        for(int i = 1; i <= n; i++){
            rez *= i;
        }
        return rez;
    }
    public static void main(String[] args) {
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(3, 1));
    	
    }
}
