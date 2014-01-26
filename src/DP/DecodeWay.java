package DP;

public class DecodeWay {
	//f(n) = f(n-1) + f(n-2) if 1 <= a[n-1]a[n] <= 26
	//00,10
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for(int i = 1; i <= len; i++){
            if(s.charAt(i-1) >= '1'){
                if(i == 1){
                    dp[i] = 1;
                }else{
                    dp[i] += dp[i-1];
                }
            }
            if(i > 1){
                String twoLetters = s.substring(i-2, i);
                if(twoLetters.compareTo("26") <= 0 && twoLetters.charAt(0) != '0' && twoLetters.charAt(0) != '0'){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len];
    }
    
    public static void main(String[] args) {
    	DecodeWay test = new DecodeWay();
    	System.out.println(test.numDecodings("10"));
    }	
}
