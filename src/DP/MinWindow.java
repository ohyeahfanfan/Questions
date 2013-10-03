package DP;

public class MinWindow {
	/* Minimum Window Substring 
	 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

		For example,
		S = "ADOBECODEBANC"
		T = "ABC"
		Minimum window is "BANC".
		
		Note:
		If there is no such window in S that covers all characters in T, return the emtpy string "".
		
		If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
	 * 
	 */
	 public String minWindow(String S, String T) {
	        String minWindow = "";
	        int minLen = Integer.MAX_VALUE;
	        int[] targetTable = new int[256];
	        int[] realTable = new int[256];
	        int count = 0;
	        for(int i = 0; i < T.length(); i++){
	            char c = T.charAt(i);
	            if(targetTable[c] == 0){
	                count++;
	            }
	            targetTable[c] += 1;
	        }
	        int end = 0;
	        int start = 0;
	        while(end < S.length()){
	            if(count > 0){
	                char c = S.charAt(end);
	                if(targetTable[c] != 0){
	                    realTable[c] += 1;
	                    if(targetTable[c] == realTable[c]){
	                      count--;   
	                    }
	                }
	                end ++;
	            }
	            while(count == 0){
	                char c = S.charAt(start);
	                if(targetTable[c] != 0){
	                    realTable[c] -= 1;
	                    if(realTable[c] < targetTable[c]){
	                        count++;
	                        String window = S.substring(start, end);
	                        if(window.length() < minLen){
	                            minWindow = window;
	                            minLen = window.length();
	                        }
	                    }
	                }
	                start++;
	            }
	        }
	        return minWindow;
	    }
}
