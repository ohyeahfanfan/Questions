package SpreadSheetCalculator;

public class OpToken extends Token{
	public static boolean isValidToken(String word){
		if(word.equals("+")
				||word.equals("-")
				||word.equals("*")
				||word.equals("/")
				||word.equals("++")
				||word.equals("--")){
			return true;
		}else{
			return false;
		}
	}
	public static OpToken createOpToken(String word) throws Exception{
		if(word.equals("+")){
			 return new PlusOpToken();
		}else if(word.equals("-")){
			return new MinusOpToken();
		}else if(word.equals("*")){
			return new MultiplicationOpToken();
		}else if(word.equals("/")){
			return new DivisionOpToken();
		}else if(word.equals("++")){
			return new IncrementOpToken();
		}else if(word.equals("--")){
			return new DecrementOpToken();
		}else{
			throw new Exception("invalid operation token");
		}
	}
	public double getValue(){
		return 0;
	}
}
