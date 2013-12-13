package Recursive;

import java.util.ArrayList;
import java.util.Collections;

import MergeOrAdd.AddBinary;

/*
 *
 * Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 */
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
        /* n = 1 [0, 1]
         *       [0, 1, 1, 0]
         * n = 2 [00, 01, 11, 10]
         * n = 3 [000, 001, 011, 010, 110, 111, 101, 100]
         * Graycode(n) = add 0 to Graycode(n-1) + add 1 to Reversed(Graycode(n-1));
         */
        if(n == 0) {
            ArrayList<Integer> rez = new ArrayList<Integer>();
            rez.add(0);
            return rez;
        }
        ArrayList<Integer> pre = grayCode(n-1);
        ArrayList<Integer> reversedPre = new ArrayList<Integer>(pre);
        Collections.reverse(reversedPre); // reverse an ArrayList
        int additional = (int) Math.pow (2,n-1); // 2 ^ n return double
        for(int i = 0; i < reversedPre.size(); i++){
            int val = reversedPre.get(i);
            val += additional;
            reversedPre.set(i, val); 
        }    
        pre.addAll(reversedPre); //merge two ArrayLists
        return pre;
    }
	
	public static void main(String args[] ) {
		GrayCode gc = new GrayCode();
		ArrayList<Integer> rez = gc.grayCode(3);
		rez.toArray();
    }
}
