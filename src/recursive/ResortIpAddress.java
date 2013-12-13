package Recursive;
import java.util.ArrayList;
/*
 * "1111"
 * Output:	["1.1.1.1","1.1.11","1.11.1","1.111","11.1.1","11.11","111.1"]
 * Expected:	["1.1.1.1"] 
 * 
 */
public class ResortIpAddress {
	public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> rez = new ArrayList<String>();
        String ip = "";
        generateIpAddress(s, 0, rez, ip, 4);
        return rez;
    }
    public void generateIpAddress(String s, int index, ArrayList<String> rez, String ip, int leftRound){
        if(index == s.length() && leftRound == 0){
            rez.add(ip);
            return;
        } 
        if(leftRound <= 0) return;
        for(int end = index + 1; end <= index + 3 && end <= s.length(); end++){
            String cur = s.substring(index, end);
            if(cur.charAt(0) == '0' && cur.length() > 1) continue;
            int num = Integer.parseInt(cur);
            String nextIp;
            if(num <= 255 && num >= 0){
                if(ip.equals("")){
                    nextIp = cur;
                }else{
                    nextIp = ip + "." + cur;
                }
                
                generateIpAddress(s, end, rez, nextIp, leftRound - 1);
            }
        }
    }
    public static void main(String[] args) {
    	ResortIpAddress obj = new ResortIpAddress();
    	obj.restoreIpAddresses("0000");
    }
}
