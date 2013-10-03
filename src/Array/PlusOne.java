package Array;

public class PlusOne {
	/*
	 * http://leetcode.com/onlinejudge#question_66
	 * Plus One
	 * Given a number represented as an array of digits, plus one to the number. 
	 * 
	 */
	public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        
        if(carry > 0){
            int[] rez = new int[digits.length+1];
            rez[0] = 1;
            for(int i = 1; i < rez.length; i++){
                rez[i] = digits[i-1];
            }
            return rez;
        }
        return digits;
    }
}
