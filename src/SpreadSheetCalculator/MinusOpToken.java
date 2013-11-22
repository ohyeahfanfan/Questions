package SpreadSheetCalculator;

public class MinusOpToken extends OpToken {
	public MinusOpToken(){
		
	}
	
	public double calculate(double a, double b){
		return a - b;
	}
	
	public String toString(){
		return "-";
	}
}
