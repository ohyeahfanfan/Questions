package String;
/*
 * Valid PalindromeJan 135247 / 16727
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome
 * 
 * 
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() < 2) return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            boolean validC1 = isAlphanumeric(c1);
            boolean validC2 = isAlphanumeric(c2);
            if(validC1 && validC2 && isSame(c1, c2)){
                start++;
                end--;
            }else if(!validC1){
                start++;
            }else if(!validC2){
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isSame(char c1, char c2){
        if(c1 == c2){
            return true;
        }
        
        if(c1 >= 'A' && c1 <='Z'){
            c1 = (char)('a' + c1-'A');
            if(c1 == c2){
                return true;
            }
        }
        
        if(c2 >= 'A' && c2 <='Z'){
            c2 = (char)('a' + c2-'A');
            if(c1 == c2){
                return true;
            }
        }
        return false;    
    }
    
    public boolean isAlphanumeric(char c){
        if(c <= 'z' && c >= 'a'){
            return true;
        }else if(c <= 'Z' && c >= 'A'){
            return true;
        }else if(c <= '9' && c >= '0'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
    	ValidPalindrome vp = new ValidPalindrome();
    	vp.isPalindrome("aA");
    }
}
