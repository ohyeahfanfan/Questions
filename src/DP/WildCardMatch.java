package DP;

import Array.MaxPointsInLine;
import Array.MaxPointsInLine.Point;

public class WildCardMatch {
	public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int starIndex = -1;
        int sMatchedTail = sIndex;
        while(sIndex < s.length()){
        	if(pIndex == p.length()){
        		if(p.charAt(pIndex-1) == '*')
        			break;
        		else
        			return false;
        	}
            char pChar = p.charAt(pIndex);
            char sChar = s.charAt(sIndex);
            if(pChar == '?' || pChar == sChar){
                pIndex++;
                sIndex++;
            }else if(pChar == '*'){
                starIndex = pIndex++;
                sMatchedTail = sIndex;
            }else if(starIndex != -1){
                //star need to match one more char (++sMatchedTail)
                //keep moving sIndex until find character p.charAt(starIndex+1) in s;
            	//eg: s = "abacc" p = "a*c"
                pIndex = starIndex + 1;
                sIndex = ++sMatchedTail;
            }else{
                return false;
            }
            
        }
        while(pIndex < p.length() && p.charAt(pIndex) == '*'){
            pIndex++;
        }
        return pIndex == p.length(); 
    }
	public static void main(String[] args) {
    	WildCardMatch obj = new WildCardMatch();
    	System.out.println(obj.isMatch("aa", "*"));
    }
}

