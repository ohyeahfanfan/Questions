package DP;

import java.util.ArrayList;
import java.util.Hashtable;

public class FindSubstring {
//barfoobar
		public ArrayList<Integer> findSubstring(String S, String[] L) {
	        ArrayList<Integer> startIndices = new ArrayList<Integer>();
	        Hashtable<String, Integer> targetTable = new Hashtable<String, Integer>();
	        Hashtable<String, Integer> realTable = new Hashtable<String, Integer>();
	        if(S==null || S.length()==0 || L==null || L.length == 0 || S.length() < L[0].length()) return startIndices;
	        int targetCount = 0;
	        int realCount = 0;
	        //init Target Table
	        for(String word : L){
	            if(targetTable.containsKey(word)){
	            	int times = targetTable.get(word);
	            	targetTable.put(word, ++times);
	            }else{
	            	targetTable.put(word, 1);
	            	targetCount ++;
	            }
	        }
	        realCount = targetCount;
	        //1. start iterator
	        //2. end iterator
	        // case 1: word not in dict: empty realTable & reset realCount
	        // case 2: word in dict, but realCount != 0 =>  realTable.get(word)==targetTable.get(word) then realCount --;
	        // case 3: word in dict, but realCount == 0 =>  add start index, start move one, realCount++, realTable.get(word)-- "barfoobar" ["bar", "foo"]   
	        int start = 0;
	        Iterator end = new Iterator(L[0].length(),S,0);
	        while(end.hasNext()){
	        	String word = end.next();
	        	if(!targetTable.containsKey(word)){
	        		realTable = new Hashtable<String, Integer>();
	        		realCount = targetCount;
	        		start++;
	        		end = new Iterator(L[0].length(), S, start);
	        	}else{
	        		if(realTable.containsKey(word)){
	        			int times = realTable.get(word);
	        			realTable.put(word, ++times);
		        	}else{
		        		realTable.put(word, 1);
		        	}
	        		if(realTable.get(word) == targetTable.get(word)){
	        			realCount--;
	        			if(realCount == 0){
	        				startIndices.add(start);
	        				start++;
	        				end = new Iterator(L[0].length(), S, start);
	        				realTable = new Hashtable<String, Integer>();
	    	        		realCount = targetCount;
	        			}
	        		}else if(realTable.get(word) < targetTable.get(word)){
	        			
	        		}else{
	        			start++;
        				end = new Iterator(L[0].length(), S, start);
        				realTable = new Hashtable<String, Integer>();
    	        		realCount = targetCount;
	        		}
	        	}
	        }
	        return startIndices;
	    }
	    class Iterator{
	        int index = 0;
	        int steps = 0;
	        String str = null;
	        public Iterator(int steps, String s, int start){
	            this.steps = steps;
	            this.str = s;
	            index = start;
	        }
	        
	        public boolean hasNext(){
	            if(str != null && index + steps <= str.length()) return true;
	            else return false;
	        }
	        public String next(){
	            if(str != null && index + steps <= str.length()){
	                String sub = str.substring(index, index + steps);
	                index += steps;
	                return sub;
	            }else{
	                return null;
	            }
	        }
	    }

	
	//"aaa" ["aa", "aa"]
	/*
	 *Input:	"abababab", ["a","b","a"]
Output:	[0,1,2,3,4]
Expected:	[0,2,4] 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubstring f = new FindSubstring();
		String[] array = {"a", "b", "a"};
		ArrayList<Integer> indice = f.findSubstring("abababab", array);
		System.out.println(indice.size());
	}

}
