package Bit;

public class IsPalindrom {

	/*
	 * Amazon 2nd phone interview April 2013 
	 * 
	 * Check if the number is palindrome if
	 * 101 return true;
	 * 11011 return true;
	 * 10 return false;
	 * negative number bitwise operation is based on two complement
	 */
	/*
	 * System.out.println(-1 >> 2); // add 1 //keep 符号位置 signed shift 
	 * System.out.println(-3 >> 1); 
	 * System.out.println(-1 >>> 1); //2147483647 带着符号右边移动  unsigned shift
	 * System.out.println(-1 >>> 2); //1073741823
	 * 所以移动出了整数
	 */
	public boolean isPalindrom(int num) {
		// 1. first get leading 1
		// 2. two pointers right and left
		long lnum = num;
		if (lnum < 0) {
			lnum = -lnum;
		}
		// get first bit which is one
		// calculate right pointer
		long right = 1;
		long copy = lnum;
		while (copy > 1) {
			copy >>= 1;
			right <<= 1;
		}
		// move pointers and compare
		// both 1s at the corresponding bit
		// both 0s at the corresponding bit
		// since the bits are not at the same position
		// even same 1s or same 0s we can not compare them by equals
		long left = 1;
		while (right > left) {
			long leftBit = lnum & left;
			long rightBit = lnum & right;
			if ((leftBit > 0 && rightBit > 0)
					|| (leftBit == 0 && rightBit == 0)) {
				left <<= 1;
				right >>= 1;
			} else {
				return false;
			}
		}
		return true;

	}

	public boolean isPalindomWrong(int num) {
		int start = 1;
		// !!!!
		int end = 1 << 30;
		while (start < end) {
			// get current bit of num;
			int left = num & start;
			int right = num & end;
			// both 1s at the corresponding bit
			// both 0s at the corresponding bit
			// since the bits are not at the same position
			// even same 1s or same 0s we can not compare them by equals
			if (left > 0 && right > 0 || (left == 0 && right == 0)) {
				start <<= 1;
				end >>= 1;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		/*
		IsPalindom isp = new IsPalindom();
		System.out.println(isp.isPalindom(0xffffffff));
		System.out.println(isp.isPalindom(2));
		System.out.println(isp.isPalindom(5));
		System.out.println(isp.isPalindom(-1));
		System.out.println(isp.isPalindom(1 << 31));*/

		// System.out.println(isp.isPalindom(0xffffffff));
		// System.out.println(isp.isPalindomWrong(0x0000));
		// System.out.println(isp.isPalindomWrong(0x00000002));
		// 10 => fffffffd + 1 => fffffffe
		

	}

}
