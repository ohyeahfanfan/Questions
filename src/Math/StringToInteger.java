package Math;

public class StringToInteger {
	/*****String to Integer (atoi)*********
     * Implement atoi to convert a string to an integer.
     * 
     * 1. negative
     * 2. overflow negative
     * 3. leading space/after space
     * 4. +1!!
     * "+00131204"	     131204	    131204	
       "-01324000"	     -1324000	-1324000	
	   "2147483647"	     2147483647	 2147483647	 not overflow
	   "-2147483648"	 -2147483648 -2147483648 not overflow	
	   "2147483648"	     2147483647	  2147483647 overflow
	   "-2147483649"	-2147483648	-2147483648  overflow
	   4. '9'vs 9
	   
     */
    public int atoi(String str) {
        //negative number
        long result = 0;
        if(str==null)return 0;
        //!!remove the space in the beginning//!!remove the space in the beginning
        str = str.trim();
        //"" or "   "
        if(str.length() == 0) return 0;
        boolean neg = false;
        //use long to handle overflow
        long limit = Integer.MAX_VALUE;//2^31-1
        int index = 0;
        if(str.charAt(index)=='-'){
            index++;
            neg = true;
            limit = Integer.MIN_VALUE;//!!!!! -2^31, then 2^31 overflow 
            limit = -limit;
        //!!! start from "+"
        }else if(str.charAt(index)=='+'){
            index++;
        }
        for(;index < str.length(); index++){
            char c = str.charAt(index);
            int digit = c - '0';
            //'9' vs 9 
            if(digit > 9 || digit < 0) break; //stop, print current number eg 111a return 111
            result =result * 10 + digit;
            if(result > limit){
            	result = limit;//!!!if overflow, result equals limit
            	break;
            }
        }
        if(neg)result=-result;
        return (int)result;
    }
}
