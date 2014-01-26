import java.util.ArrayList;
import java.util.Arrays;

import CombinationWithDup.FourSum;

/*
 * Next Permutation 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1 
 * 
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
        int left = num.length - 2;
        while(left >= 0 && num[left] >= num[left + 1] ){
            left --;
        }
        if(left < 0) {
        	Arrays.sort(num);
        	return;
        }
        int i = left + 1;
        int rightVal = Integer.MAX_VALUE;
        int right = -1;
        while(i < num.length){
            if(num[left] < num[i] && rightVal > num[i]){
                rightVal = num[i];
                right = i;
            }
            i++ ;
        }
        swap(right, left, num);
        Arrays.sort(num, left + 1, num.length);
        
    }
    public void swap(int a, int b, int[] num){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    public static void main(String[] args) {
    	NextPermutation obj = new NextPermutation();
    	int[] num = {1,2};
    	obj.nextPermutation(num);
		System.out.println();
    }
}
