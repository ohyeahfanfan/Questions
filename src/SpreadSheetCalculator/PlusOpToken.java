package SpreadSheetCalculator;

public class PlusOpToken extends OpToken {
	
	public PlusOpToken(){
	
	}
	
	public double calculate(double a, double b){
		return a + b;
	}
	public String toString(){
		return "+";
	}
}
