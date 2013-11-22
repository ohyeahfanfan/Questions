package Math;

public class Pow {
	/*
	 * @ Question
	 * Pow(x, n)
	 * Implement pow(x, n).
	 * 
	 * @ submission 10/3/2013
	 * 
	 * Test Case: 
     * 0^0
     * 1^0
     * 2^0
     * 3^2
     * 3^3
     * 3^-3
     * Recursive O(logn)
     * Iterative O(logn)
     * Iterative O(n)
     */
    public double powRecursive(double x, int n) {
        if(n == 0) return 1; //4^0
        if(n == 1) return x;
        boolean neg = false;
        if(n < 0){
            neg = true;
            n = -n; //!!!overflow if n = -2^31
        }
        double sub = powRecursive(x, n/2);
        double rez = sub * sub;
        if(n % 2 != 0){
            rez *= x;
        }
        if(neg){
            rez = 1/rez;
        }
        return rez;
    }
    /*
     * 10^15
     * 00011111
     * 10^8 * 10^4 * 10^2 * 10*1
     */
    public double powIterative(double x, int n) {
        if(n == 0) return 1;
        boolean neg = false;
        if(n < 0) {
        	neg = true;
        	n = -n;
        }
        int bit = 1;
        double base = x;
        double rez = 1;
        //完全想不出来了 按bit
        while(n > 0){
        	if((n & bit) == 1){
        		rez *= base;
        	}
        	n >>= 1;
        	base *= base;
        }
        if(neg) rez = 1/rez;
        return rez;
    }
    /*
     *  O(n)
     */
    public double powN(double x, int n){
    	boolean neg = false;
        if(n < 0){
            neg = true; //!!!!!
            n = -n;
        }
        double rez = 1;
        for(int i = 0; i < n; i++){
        	rez *= n; 
        }
        if(neg) rez = 1/rez;
        return rez;
    }
}
