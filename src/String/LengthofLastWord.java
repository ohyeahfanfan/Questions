package String;

public class LengthofLastWord {
	/*
	 *  Length of Last Word 7/22/2013
	 *  Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

		If the last word does not exist, return 0.
		
		Note: A word is defined as a character sequence consists of non-space characters only.
		
		For example, 
		Given s = "Hello World",
		return 5.
	 * 
	 * 1. "" 
	 * 2. " "
	 * 3. "word"
	 * 5. "word  "
	 * 6. " word"
	 * 
	 */
	  public int lengthOfLastWord(String s) {
	        if(s == null) return 0;
	        int start = s.length()-1;
	        int end = start;
	        while(end >= 0){
	        	//before word
	        	if(s.charAt(start)==' '){
	        		start--;
	        		end--;
	        	//end of word
	        	}else if(s.charAt(end)==' '){
	        		//end at ' '
	        		break;
	        	//middle of word
	        	}else{
	        		end--;
	        	}
	        }
	        //"" or "  "
	        if(end == start) return 0;
	        //"word" " word" !!! don't need + 1
	        return start - end;
		}
}
