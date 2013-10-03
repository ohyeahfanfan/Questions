package String;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindrom {

	public String findLongestPalindrom(String str){
		if(str == null) return null;
		String longest = "";
		for(int i = 0; i < str.length(); i++){
			String subLongest1 = longestPalindromOdd(str, i, i+1);
			String subLongest2 = longestPalindromEven(str, i-1, i+1);
			String subLongest = (subLongest2.length() > subLongest1.length()?subLongest2:subLongest1);
			if(subLongest.length() > longest.length()){
				longest = subLongest;
			}
		}
		return longest;
		
	}
	public String longestPalindromOdd(String str, int start, int end){
		while(start >= 0 && end < str.length()){
			if(str.charAt(start) == str.charAt(end)){
				start--;
				end++;
			}
		}
		String longest = str.substring(start-1, end);
		return longest;
		
	}
	public String longestPalindromEven(String str, int start, int end){
		while(start >= 0 && end < str.length()){
			if(str.charAt(start) == str.charAt(end)){
				start--;
				end++;
			}
		}
		if(start < 0) start = 0;
		if(end > str.length()) end = str.length();
		String longest = str.substring(start, end);
		return longest;
	}
	
	public boolean findSum(int[] arr, int target){
		if(arr==null || arr.length == 0) return false;
		Hashtable<Integer, Integer> dict = new Hashtable<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			int key = arr[i];
			if(dict.containsKey(key)){
				int times = dict.get(key);
				dict.put(key,++times); 
			}else{
				dict.put(key, 1);
			}
		}
		for(int i = 0; i < arr.length; i++){
			int num = arr[i];
			int key = target - num;
			if(dict.containsKey(key)){
				if(key != num) {
					return true;
				}else if(dict.get(key)>=2){
					return true;
				}
			}
		}
		return false;
	}
}
