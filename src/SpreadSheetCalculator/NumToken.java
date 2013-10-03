package SpreadSheetCalculator;

public class NumToken extends Token {
	
	/*
	 * we treat following number to be valid token -1 +1 1
	 */
	private double value;
	public static boolean isValidToken(String word) {
		int digit = word.charAt(0) - '0';
		if (word.charAt(0) == '+' || word.charAt(0) == '-') {
			digit = word.charAt(1) - '0';
		}
		if (digit >= 0 && digit <= 9) {
			return true;
		}
		return false;
	}

	public NumToken(String word) throws Exception {
		value = atof(word);
	}
	
	public NumToken(double num){
		value = num;
	}
	public double getValue() {
		return value;
	}

	// atof
	// -13.24
	// +1.32
	// 1.32
	// 0.32
	// 32.0
	// +1.32e10?
	// invalid?
	// assume this is a valid str;
	private double atof(String str) throws Exception {
		if (isValidFloat(str))
			throw new Exception("Invalid float format");
		double rez = 0;
		boolean neg = false;
		boolean point = false;
		double multiple = 0.1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+') {
				neg = false;
			} else if (str.charAt(i) == '-') {
				neg = true;
			} else if (str.charAt(i) == '.') {
				point = true;
			} else {
				int num = str.charAt(i) - '0';
				if (point == false) {
					rez *= 10;
					rez += num;
				} else {
					rez += num * multiple;
					multiple *= 0.1;
				}
			}
		}
		return (neg ? -rez : rez);
	}

	/*
	 * .3 .0 0.1 1. 1.3 1.+1
	 */
	public boolean isValidFloat(String str) {
		boolean sign = false;
		boolean point = false;
		boolean num = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				// should be the first
				if (sign || num || point)
					return false;
			} else if (str.charAt(i) == '.') {
				if (point || !num)
					return false;
			} else if (str.charAt(i) <= '9' && str.charAt(i) <= '0') {
				num = true;
			} else {
				return false;
			}

		}
		return true;
	}
	
	public String toString(){
		String formatted = String.format("%.0f", value);
		return formatted;
	}
	

}
