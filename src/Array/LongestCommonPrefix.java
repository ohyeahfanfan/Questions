package Array;
/*
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * 
 * 
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        StringBuffer prefix = new StringBuffer();
        if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 0; j < strs.length; j++){
                if(i > strs[j].length()-1)
                 return prefix.toString();
                if(strs[0].charAt(i)!=strs[j].charAt(i))
                 return prefix.toString();
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}
