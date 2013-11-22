package Math;

/*
 * @Question:Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @Solution:
 * 1. dividend or/and divisor are negative number
 *   a. -2^31 => 2^31 overflow => long
 * 2. compute the biggest bit of the quotient
 * 	  biggestBit: the biggest bit of quotient
 * 3. compute the rest lower bit of the quotient
 * 
 * @point:
 * 1. negative
 * 2. overflow
 * 3. bit operation
 * 
 * @Test Case
 * 1. 正正
 * 2. 负负
 * 3. 正负
 * 4. 负正
 * 5. can be divided exactly
 * 6. can not be divided exactly
 */

public class DivideTwoInteger {
	public int divide(int dividendInt, int divisorInt) {
		//1. negative number 
		// a. dividend !!or/and!! divisor are/is negative number 
		// b. -2^31 => 2^31 overflow => long
		boolean neg = false;
		long dividend = dividendInt;
		long divisor = divisorInt;
		if (dividend < 0) {
			neg = true;
			dividend = -dividend; // should we think about overflow?
		}
		if (divisor < 0) {
			neg = !neg;
			divisor = -divisor;
		}
		//2. compute the biggest bit of quotient
		int biggestBit = 1; //highest bit of quotient
		long product = divisor; // biggestBit * divisor
		//!!!!!!!!avoid product overflow
		//eg: dividend = 2^30 + 1
		//    product = 2^30
		//if we keep left shift product, overflow will happen if product is int
		//since current product is long, product << 1 or product + product will work too
		while (product <= dividend - product) { //!!! <=
			biggestBit <<= 1;
			product <<= 1;
		}
		//3. compute the rest lower bits of quotient
		//keep right shift product and biggest bit 
		//keep remove product from dividend until dividend < divisor
		//quotient += biggestBit;
		int quotient = 0;
		while (dividend >= divisor) { //!!! >=
			if (product <= dividend) { //!!! <=
				dividend -= product;
				quotient += biggestBit;
			}
			product >>= 1;
			biggestBit >>= 1;
		}
        return (neg ? -quotient : quotient);
	}

	public static void main(String[] args) {
		DivideTwoInteger d = new DivideTwoInteger();
		int q = d.divide(-2147483648, 1);
		System.out.println(q);
	}
}
