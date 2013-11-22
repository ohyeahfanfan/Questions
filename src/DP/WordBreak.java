package DP;
import java.util.HashSet;
import java.util.Set;

/*
 * @Questions:
 * Word Break
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @submission 10/14/2013
 * 
 * @solution
 * f(n): whether if s(0,n) can be segmented into a space-separated sequence of one or more dictionary words
 * f(n) = true if exists f(i) =  true i <= n and s(i+1, n) is a word in the dict
 * 
 * @ time complexity 
 * O(N^2)
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] exists = new boolean[s.length()];
		for (int end = 0; end < s.length(); end++) {
			String word = s.substring(0, end + 1);
			if (dict.contains(word)) {
				exists[end] = true;
				continue;
			}
			for (int start = end;  start > 0; start--) {
				word = s.substring(start, end + 1);
				if (exists[start - 1] && dict.contains(word)) {
					exists[end] = true;
					break;
				}
			}
		}
		return exists[s.length() - 1];
	}

	/* 
	 * f(n) = true if any f(i) = true (i < n) substring(i+1, n+1) in dict
	 * O(2^N)
	 * public boolean wordBreakExponential(String s, Set<String> dict) { 
	 * // Note: The Solution object is instantiated only once and is reused by each test case.
	 *  if(s == null) return true; int startIndex = 0; 
	 *  return search(startIndex, s, dict); 
	 *  } 
	 *  public boolean search(int start, String s, Set<String> dict){ 
	 *  	if(start == s.length()) return true; 
	 *  	for(int end = start + 1; end <= s.length(); end++){ 
	 *  		String word = s.substring(start,end); 
	 *  		if(dict.contains(word)){ 
	 *  			boolean rez = search(end, s, dict); 
	 *  			if(rez== true) return true; 
	 *  		} 
	 *  	} 
	 *  	return false; 
	 *  }
	 */
	public boolean wordBreakEx(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Set<Integer> steps = new HashSet<Integer>();
		for (String word : dict) {
			steps.add(word.length());
		}
		if (s == null)
			return true;
		int startIndex = 0;
		return search(startIndex, s, dict, steps);
	}

	public boolean search(int start, String s, Set<String> dict, Set<Integer> steps) {
		if (start == s.length())
			return true;
		for (int step : steps) {
			if (start + step > s.length())
				continue;
			String word = s.substring(start, start + step);
			if (dict.contains(word)) {
				boolean rez = search(start + step, s, dict, steps);
				if (rez == true)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		System.out.println(wb.wordBreak("ab", dict));
	}
}
