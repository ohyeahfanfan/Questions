package Bit;

public class SingleNumberII {
	/*
	 * Single Number II
	 * Given an array of integers, every element appears three times except for one. Find that single one.
	 * Note:
	 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 * 
	 */
	

	public int singleNumberFast(int[] A) {
        int[] bits = new int[32];
        int bit = 1;
        int num = 0;
        int base = 1;
        for(int i = 0; i < 32; i++){
        	for(int j = 0; j < A.length; j++){
        		if((A[j] & bit) != 0){
        			bits[i] ++ ;
        			bits[i] %= 3;
        		}
        	}
        	num += bits[i] * base;
        	base <<= 1;
        	bit <<= 1;
        }
        return num;
    }
	public int singleNumber(int[] A) {
        int[] bits = new int[32];
        for(int i = 0; i < A.length; i++){
            int cur = A[i];
            int bit = 1;
            for(int j = 0; j < 32; j++){
                if((bit & cur) != 0){
                    bits[j] ++;
                    bits[j] %= 3; 
                }
                bit <<= 1;
            }
        }
        int rez = 0;
        int base = 1;
        for(int i = 0; i < 32; i++){
            rez += bits[i] * base;
            base <<= 1;
        }
        return rez;
    }
	public static void main(String[] args) {
		SingleNumberII s = new SingleNumberII();
		int[] num = {2,2,3,2};
		int single = s.singleNumber(num);
		System.out.println(single);
	}
}
