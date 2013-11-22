package String;
/*
 * @Question:
 * Implement strStr()
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 * 
 * @test case:
 * 1. haystack is shorter than needle 
 * 	  eg: "aaa" vs "aaaa"
 * 2. haystack is longer than needle but not contains needle
 *    eg: "big" vs "it"
 *    
 */
public class Strstr {
	public String strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++){
            boolean partOfHaystack = true;
            //!!!!!!!!!!!!!!!!
            if(i + needle.length() > haystack.length()) return null;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    partOfHaystack = false;
                }
            }
            if(partOfHaystack == true) return haystack.substring(i);
        } 
        if ( haystack == "" && needle == "" ) 
        	return "";
        
        return  null;
    }
	public static void main(String[] args) {
		Strstr s = new Strstr();
		System.out.println(s.strStr("", ""));
	}
}
