package Math;

import DP.UniquePathII;
/*
 * Roman to Integer 
 * Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999. 
 * 
 *  XXXIV
 *  The value of each letter of Roman number should increase from left to right.
 *  if the value is smaller than next letter, the value should be negative
 *  
 */
public class RomanToInt {
	public int romanToInt(String s) {
        int val = 0;
        if(s == null) return val;
        for(int i = 0; i < s.length(); i++){
            int cur = getVal(s.charAt(i));
            int next = (i+1 == s.length() ? 0 : getVal(s.charAt(i+1)));
            if(cur < next){
                val -= cur;
            }else{
                val += cur;
            }
        }
        return val;
    }
    public int getVal(char letter){
        if(letter == 'I'){
            return 1;
        }else if(letter == 'V'){
            return 5;
        }else if(letter == 'X'){
            return 10;
        }else if(letter == 'L'){
            return 50;
        }else if(letter == 'C'){
            return 100;
        }else if(letter == 'D'){
            return 500;
        }else if(letter == 'M'){
            return 1000;
        }
        return -1;
    }
    public static void main(String args[] ) {
    	RomanToInt obj = new RomanToInt();
    	System.out.println(obj.romanToInt("XIX"));
	 }
}
