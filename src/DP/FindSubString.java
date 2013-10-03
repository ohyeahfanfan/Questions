package DP;

import java.util.ArrayList;
import java.util.Hashtable;

public class FindSubString {
	/*
	 * Substring with Concatenation of All Words 
	 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
	 * For example, given:
     * S: "barfoothefoobarman"
     * L: ["foo", "bar"]
	 * You should return the indices: [0,9].(order does not matter). 
	 * 
	 * 
	 */
	public ArrayList<Integer> findSubstring(String S, String[] L) {
	        ArrayList<Integer> starts = new ArrayList<Integer>();
	        if(S == null || S.length() == 0 || L == null || L.length == 0) return starts;
	        Hashtable<String, Integer> targetTimes = new Hashtable<String, Integer>();
	        Hashtable<String, Integer> realTimes = new Hashtable<String, Integer>();
	        int targetCount = 0;
	        for(String word : L){
	            if(targetTimes.containsKey(word)){
	                targetTimes.put(word, targetTimes.get(word) + 1);
	            }else{
	                targetTimes.put(word, 1);
	                targetCount++;
	            }
	        }
	        int steps = L[0].length();
	        for(int i = 0; i < steps; i++){
	            Iterator startIter = new Iterator(S, steps, i);
	            Iterator endIter = new Iterator(S, steps, i);
	            realTimes.clear();
	            int realCount = targetCount;
	            while(endIter.hasNext()){
	                String word = endIter.next();
	                if(realTimes.containsKey(word)){
	                    realTimes.put(word, realTimes.get(word) + 1);
	                }else{
	                    realTimes.put(word, 1);
	                }
	                if(!targetTimes.containsKey(word)){
	                    startIter = new Iterator(S, steps, endIter.curIndex);
	                	realTimes.clear();
	                    realCount = targetCount;
	                }else if(realTimes.get(word) > targetTimes.get(word)){
	                	//move start "abababab", ["a","b","a"]
	                	String kickedWord = startIter.next();
	                    realTimes.put(kickedWord, realTimes.get(kickedWord) - 1);
	                }else if(realTimes.get(word) == targetTimes.get(word)){
	                    realCount--;
	                    if(realCount == 0){
	                        starts.add(startIter.curIndex);
	                        realCount ++;
	                        //move start
	                        String kickedWord = startIter.next();
	                        realTimes.put(kickedWord, realTimes.get(kickedWord) + 1);
	                    }
	                }
	            }
	        }
	        return starts;
	    }
	    class Iterator{
	        int curIndex = 0;
	        int jumpSteps = 0;
	        String str = null;
	        public Iterator(String targetStr, int steps, int startIndex){
	            this.str = targetStr;
	            this.jumpSteps = steps;
	            this.curIndex = startIndex;
	        }
	        boolean hasNext(){
	            if(this.str !=null 
	                && this.curIndex + this.jumpSteps <= this.str.length())
	                return true;
	            else return false;
	        }
	        String next(){
	            int nextIndex = curIndex + jumpSteps;
	            if(str !=null 
	                && nextIndex <= this.str.length()){
	                String sub = this.str.substring(curIndex, nextIndex);
	                curIndex = nextIndex;
	                return sub;
	            }else{
	                return null;
	            }
	                
	        }
	    }
	
    public static void main(String[] args) {
    	//"barfoothefoobarman", ["foo","bar"]

		FindSubString ob = new FindSubString();
		//"abababab", ["a","b","a"]
		String[] L = {"foo","bar"};
		ArrayList<Integer> start = ob.findSubstring("barfoothefoobarman", L);
		System.out.println(start.toString());
    	
	}
}
