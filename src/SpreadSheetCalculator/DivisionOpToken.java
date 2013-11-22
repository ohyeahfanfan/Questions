package SpreadSheetCalculator;

public class DivisionOpToken extends OpToken{

	public double calculate(double dividend, double divisor){
		if(divisor == 0){
			if(dividend > 0) return Double.POSITIVE_INFINITY;
			if(dividend < 0) return Double.NEGATIVE_INFINITY;
			if(dividend == 0) return 0;
		}
		return dividend/divisor;
	}
	public String toString(){
		return "/";
	}
}
