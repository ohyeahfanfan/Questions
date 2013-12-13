package Math;

public class PalindromeNumber {
	
	//x = 9229
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
    	int divisor = 1;
        //how to get the first digit
        while(x/divisor >= 10){
            divisor *= 10; 
        }
        //divisor = 1000
        while(x != 0){ //???
            int lastDigit = x % 10;       //OBTAIN LAST digit %
            //after 1st round: lastDigit = 9
            int firstDigit = x / divisor; //OBTAIN FIRST digit /
            //after 1st round: firstDigit = 9
            if(lastDigit != firstDigit){
                return false;
            }
            x %= divisor;                //REMOVE the FIRST digit %
            //after 1st round: x = 229
            x /=  10;                    //REMOVE the LAST digit /
            //after 1st round: x = 22
            divisor /= 100; //divisor right shift 2 digits
            //after 1st round:divisor = 10
        }
        return true;
    }
    /*
	 * Palindrome Number
	 * Determine whether an integer is a palindrome. Do this without extra space. 
	 * 
	 * 1. negative number
	 * 2. non palindrome number 
	 * 3. non palindrome number overflow
	 * 4. palindrome num
	 * 
	 */
	public boolean isPalindrome_ (int x) {
       // !!!!
	   int original = x;
       long reversed = 0;
       long limit = Integer.MAX_VALUE;
       if(x < 0){
           limit = Integer.MIN_VALUE;
           limit = -limit;
           x = -x;
       }
       while(x > 0){
           int digit = x % 10;
           x = x/10;
           reversed *= 10;
           reversed += digit;
           if(reversed > limit){
               return false;
           }
       }
       if(reversed==original) return true;
       return false;
    }
	/*
	 * It turns out that comparing from the two ends is easier. 
	 * First, compare the first and last digit. 
	 * If they are not the same, it must not be a palindrome. 
	 * If they are the same, chop off one digit from both ends and continue until you have no digits left, 
	 * which you conclude that it must be a palindrome. 
	 * 
	 */
	boolean isPalindromeTwoPointers_(int x) {
		  if (x < 0) return false;
		  int div = 1;
		  while (x / div >= 10) {
		    div *= 10;
		  }        
		  while (x != 0) {
		    int l = x / div;
		    int r = x % 10;
		    if (l != r) return false;
			//!!!!!
		    x = (x % div) / 10;
		    div /= 100;
	  }
	  return true;
	}

	 public static void main(String[] args) {
		 PalindromeNumber pn = new PalindromeNumber();
		 pn.isPalindrome(1001);
	 }
}
