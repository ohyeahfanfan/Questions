package Recursive;

/*
 * @Palindrome Partitioning II 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * 
 */
public class PalindromePartitioningII {
	 public int minCut(String s) {
	       //1. get all palidromes
	       //2. f(i) = min(f(j) + 1) if substring(j+1, i+1) is palindrome
	       boolean[][] palindromes = new boolean[s.length()][s.length()];
	       for(int end = 0; end < s.length(); end++){
	           for(int start = end; start >= 0; start--){
	               if(s.charAt(start) == s.charAt(end) && (end-start <= 2 || palindromes[start+1][end-1])){
	                   palindromes[start][end] = true;
	               }
	           }
	       }
	       int[] minCuts = new int[s.length()];
	       for(int end = 0; end < s.length(); end++){
	           int minCut = Integer.MAX_VALUE;
	           for(int start = 0; start < end; start++){
	               if(palindromes[start+1][end]){
	            	   minCuts[end] = Math.min(minCut, minCuts[start] + 1);
	               }
	           }
	       }
	       return minCuts[s.length()-1];
	    }
	 /*public int minCut(String s) {
     Hashtable<String, Integer> rez = new Hashtable<String, Integer>();
     rez.put("curCut", 0);
     rez.put("minCut", Integer.MAX_VALUE);
     search(0, s, rez);
     return rez.get("minCut")-1;
 }

 public void search(int start, String s, Hashtable<String, Integer> rez){
     if(start == s.length()){
     	int minCut = Math.min(rez.get("curCut"), rez.get("minCut"));
     	rez.put("minCut", minCut);
         return;
     }    
     for(int end = s.length() ; end > start; end--){
         String word = s.substring(start, end);
         if(isPalindrome(word)){
         	rez.put("curCut", rez.get("curCut")+1);
             search(end, s, rez);
             rez.put("curCut", rez.get("curCut")-1);
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
 }*/
	
	 public static void main(String[] args) {
		PalindromePartitioningII p = new PalindromePartitioningII();
		int cut = p.minCut("aab");
		System.out.println(cut);
	}
}
