package Bit;

public class SwapNumInPlace {

	/**
	 *	CRC 150
	 *	Problem 17.1
	 *	Write a function to swap a number in place.
	 *  
	 *  swap a to b
	 */
	public void swap(int[] num){
		num[0] = num[0] ^ num[1];
		num[1] = num[0] ^ num[1];
		num[0] = num[0] ^ num[1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
