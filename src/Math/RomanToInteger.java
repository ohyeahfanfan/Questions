package Math;

public class RomanToInteger {
	public static int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // traverse each letter in s
        // if s[i] > s[i+1] sum += s[i]
        // if s[i] < s[i+1] sum -= s[i]
        // if s[i] == s[i+1] wait
        if(s==null||s.length()==0) return 0;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // IIV is impossible. as long as we have same letter together II we should sum
            //!!!!compare getVal() instead of char
            if(i == s.length()-1 || getVal(c) >= getVal(s.charAt(i+1))){
                sum += getVal(c);
            }else{
                sum -= getVal(c);
            }
        }
        return sum;
        
    }
    
      public static int getVal(char c){
            if(c=='I'){
	            return 1;
	        }else if(c=='V'){
	            return 5;
	        }else if(c=='X'){
	            return 10;
	        }else if(c=='L'){
	            return 50;
	        }else if(c=='C'){
	            return 100;
	        }else if(c=='D'){
	            return 500;
	        }else if(c=='M'){
	            return 1000;
	        }else{
	            return 0;
	        }
	    }
      public static void main(String[] args) {
  		// TODO Auto-generated method stub
    	  RomanToInteger.romanToInt("XL");
      }
}
