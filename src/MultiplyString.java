

public class MultiplyString {
	/* need to be rewritten
	 * 
	 * 
	 * Multiply Strings
	 * Given two numbers represented as strings, return
	 * multiplication of the numbers as a string.
	 * 
	 * The numbers can be arbitrarily large and are non-negative.
	 * 
	 * 
	 * 113 * 241
	 *   
	 *   113
	 *  452
	 * 226
	 * -----
	 * 27243
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 * BI ZHE XIE DE
	 */
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] rez = new int[len1 + len2];
		for(int i1 = 0; i1 < len1; i1++){
			//convert the index from reversed way
			int digit1 = num1.charAt(len1 - 1 -i1) - '0';
			int carry = 0;
			for(int i2 = 0; i2 < len2; i2++){
				int digit2 = num2.charAt(len2 - 1 - i2) - '0';
				int sum = digit1 * digit2 + carry + rez[i1 + i2];
				rez[i1 + i2]  = sum % 10;
				carry = sum / 10;
			}
			rez[i1 + len2] += carry;  
		}
		//find the most significant digit, first non zero digit from right
		int significantDigit =  rez.length - 1;
		//at least having one digit. eg. 0 * 0
		while(significantDigit > 0 && rez[significantDigit] == 0){
			significantDigit --;
		}
		//append to rez from most significant digit
		StringBuilder sb = new StringBuilder();
		while(significantDigit >= 0){
			sb.append((char)(rez[significantDigit--] + '0'));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		MultiplyString obj = new MultiplyString();
		System.out.println(obj.multiply("0", "0"));
	}
}
