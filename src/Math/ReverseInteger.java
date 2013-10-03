package Math;
/*  Reverse Integer
 *	Reverse digits of an integer.
 *	Example1: x = 123, return 321
 *	Example2: x = -123, return -321 
 *  
 *  考点：
 *  正负数，会overflow
 */
public class ReverseInteger {
	
	   public int reverse(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        long reversedNum = 0;
	        boolean neg = false;
	        long limit = Integer.MAX_VALUE;
	        //-x will overflow, if x is Integer.MIN_VALUE
	        long num = x;
	        if(num < 0){
	            neg = true;
	            //!!!!!!!!!!
	            // treat Integer.MIN_VALUE as int
	            //  -Integer.MIN_VALUE get -2147483648
	            //limit = -Integer.MIN_VALUE;
	            limit = Integer.MIN_VALUE;
	            limit = -limit;
	            num = -num;
	        }
	        
	        while(num > 0){
	            long digit = num % 10;
	            num = num / 10;
	            reversedNum *= 10;
	            reversedNum += digit;
	            if(reversedNum > limit) {
	                reversedNum = limit;
	                break;
	            }
	        }
	        if(neg) reversedNum = -reversedNum;
	        return (int)reversedNum;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long limit = Integer.MIN_VALUE;
		limit = -limit;
		System.out.println(limit);
	}

}
