package DP;

public class MinWindow {


	/*
	     * Minimum Window Substring
	     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	     * S = "ADOBECODEBANC"
	     * T = "ABC"
	     * Minimum window is "BANC".
	     *  
	     * Brute force O(N^2) n + n-1 + n-2 + n-3
	     * 1. find all the substrings of S which contain all the characters in T 
	     *   (start point keeps moving right, end point move back and forth)
	     * 2. pick the one with min length
	     * 
	     * optimize on step 1
	     * Two status
	     * S1. s.substring(start, end+1) doesn't contain all the characters in T
	     * S2. s.substring(start, end+1) contain all the characters in T
	     * 1. S1 -> S2 end pointer keeps moving right until S2 
	     * 2. S2 -> S1 start pointer keeps moving right until S1
	     *
	     * How to determine whether s.substring(start, end+1) contain all the characters in T
	     * targetTable: each character how many times appear in T
	     * realTable: each character how many times appear in current s.substring(start, end + 1)
	     * distinctCharacter: how many distinct characters T contains. 
	     * If each distinct characters appears target times in current substring, 
	     * we think s.substring(start, end + 1) contains all the characters in T.
	     * 
	     * xinde:
	     * round 1: move end 
	     * round 2: move start
	     * or 
	     * round 1: move end and move start
	     * the 2nd method is better.
	     * since move start depends on the result of move end -> (count == 0)
	     */
	   
public String minWindow(String S, String T) {
	        String minWindow = "";
	        int minLen = Integer.MAX_VALUE;
	        int[] targetTable = new int[256];
	        int[] realTable = new int[256];
	        if(T == null || S == null || S.length() < T.length()) return "";
	        //distinct characters haven't reached target times.
	        // if count == 0 means current substring contains all the characters 
	        int count = getDistinctCharactersAndTargetTable(T, targetTable);
	        int end = 0;
	        int start = 0;
	        while(end < S.length()){
	            //S1. s.substring(start, end+1) doesn't contain all the characters in T
	        	if(count > 0 ){
	                char c = S.charAt(end);
	                if(targetTable[c] > 0){
	                    realTable[c] += 1;
	                    if(realTable[c] == targetTable[c]){
	                        count--;
	                    }
	                }
	                end++;
	            }
	        	//S2. s.substring(start, end+1) contain all the characters in T
	            while(count == 0 && start <= end){
	            	char c = S.charAt(start);
	                if(targetTable[c] > 0){
	                    realTable[c] -= 1;
	                    //some character appears more than target time
	                    if(realTable[c] < targetTable[c]){
	                        count ++;
	                        String sub = S.substring(start, end);
	                        if(sub.length() < minLen){
	                            minLen = sub.length();
	                            minWindow = sub;
	                        }
	                    }
	                }
	                start ++;
	            }
	        }
	        return minWindow;
	    }
	    public int getDistinctCharactersAndTargetTable(String T, int[] table){
	        int count = 0;
	        for(int i = 0; i < T.length(); i++){
	            char c = T.charAt(i);
	            //new character c
	            if(table[c] == 0){
	                count++;
	            }
	            table[c] += 1;
	        }
	        return count;
	    }
	    //second time
	    public String minWindowII(String S, String T) {
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


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWindow mw = new MinWindow();
		String str = mw.minWindow("aa", "aa");
		System.out.println(str);
	}


}
