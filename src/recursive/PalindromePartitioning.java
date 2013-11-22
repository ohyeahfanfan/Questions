package Recursive;

import java.util.ArrayList;

/*@Question:
 * Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab"
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ] 
 * 
 * how to do the recurrence?
 * f(n): all possible palindrome partitioning of s(0,n)
 * f(n) = {f(i) U s(i+1, n)} (i < n && s(i+1, n) is a palindrome)
 */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> partition = new ArrayList<String>();
        search(0, s, partition, partitions);
        return partitions;
    }
    public void search(int start, String s, ArrayList<String> partition, ArrayList<ArrayList<String>> partitions){
        if(start == s.length()){
            ArrayList<String> copy = new ArrayList<String>(partition);
            partitions.add(copy);
            return;
        }    
        for(int end = start+1 ; end <= s.length(); end++){
            String word = s.substring(start, end);
            if(isPalindrome(word)){
                partition.add(word);
                search(end, s, partition, partitions);
                partition.remove(partition.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int start = 0; 
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start)==str.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		ArrayList<ArrayList<String>> rez = p.partition("aab");
		System.out.println();
	}
}
