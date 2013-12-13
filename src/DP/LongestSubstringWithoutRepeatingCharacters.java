package DP;

/*
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * Discuss
 * 
 * Longest Substring Without Repeating Characters is same with Minimum Window Substring
 * Two status
 * S1: s.substring(start, end) doesn't contain no duplicate
 * S2: s.substring(start, end) contains duplicate
 * 1. S1 -> S2 move end
 * 2. S2-> S1 move start
 * 
 * Minimum Window Substring
 * Two status
 * S1. s.substring(start, end+1) doesn't contain all the characters in T
 * S2. s.substring(start, end+1) contain all the characters in T
 * 1. S1 -> S2 end pointer keeps moving right until S2 
 * 2. S2 -> S1 start pointer keeps moving right until S1
 * 
 */
import java.util.HashSet;
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashSet<Character> existence =  new HashSet<Character>();
        int longest = 0;
        while(end < s.length()){
        	char tailChar = s.charAt(end);
        	//Status: S2 move start
        	if(existence.contains(tailChar)){
        		int len = end - start;
        		longest = longest > len ? longest : len;
        		while(start < end && s.charAt(start) != tailChar){
        			existence.remove(s.charAt(start));
        			start ++;
        		}
        		start ++;
        	//Status: S1 move end
        	}else{
        		existence.add(tailChar);
        	}
        	//status s2 after start move, end need to move too.
        	end ++;
        }
        
        return longest < end - start ? end - start : longest;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("bbacad"));
		System.out.println(obj.lengthOfLongestSubstring("aab"));
		System.out.println(obj.lengthOfLongestSubstring(""));
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
	}

}
