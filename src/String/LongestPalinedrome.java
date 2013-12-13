package String;
/*
 * 
 * Longest Palindromic Substring Total Accepted: 3255 Total Submissions: 15325 My Submissions
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 * Brute force solution, O(N3):
 * The obvious brute force solution is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome. There are a total of C(N, 2) such substrings (excluding the trivial solution where a character itself is a palindrome).
 * 
 * Since expanding a palindrome around its center could take O(N) time, the overall complexity is O(N2).
 * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2N-1 such centers.
 * You might be asking why there are 2N-1 but not N centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as ÒabbaÓ) and its center are between the two ÔbÕs.
 * 
 */
public class LongestPalinedrome {
	public String longestPalindromFromCenter(String str, int start, int end){
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start --;
            end ++;
        }
        return str.substring(start + 1, end);
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String oneChar = longestPalindromFromCenter(s, i, i);
            longest = oneChar.length() > longest.length() ? oneChar : longest;
            
            if(i == s.length() - 1) continue;
            String twoChars = longestPalindromFromCenter(s, i, i+1);
            longest = twoChars.length() > longest.length() ? twoChars : longest;
        }
        return longest;
    }
    public static void main(String[] args) {
		LongestPalinedrome obj = new LongestPalinedrome();
		System.out.println(obj.longestPalindrome("a"));
		System.out.println(obj.longestPalindrome("aaba"));
		System.out.println(obj.longestPalindrome(""));
		System.out.println(obj.longestPalindrome("abcadab"));
	}
}
