package SpreadSheetCalculator;

public class MultiplicationOpToken extends OpToken {
	public MultiplicationOpToken(){
		
	}
	
	public double calculate(double a, double b){
		return a * b;
	}
	public String toString(){
		return "*";
	}
}
