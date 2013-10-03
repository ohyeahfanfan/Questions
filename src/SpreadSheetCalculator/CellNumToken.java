package SpreadSheetCalculator;

public class CellNumToken extends Token{
	/*
	 * A1 
	 * A12 
	 */
	
	
	public static boolean isValidToken(String word){
		word = word.toUpperCase();
		int digit = word.charAt(0);
		if(digit <= 'Z' && digit >= 'A'){
			return true;
		}else{
			return false;
		}
	}
	public CellNumToken(String word) throws Exception{
		parse(word);
		cellNum = word;
	}
	private void parse(String word) throws Exception{
		x = word.charAt(0) - 'A';
		y = 0;
		int i = 0;
		for(i = 1; i < word.length(); i++){
			char ch = word.charAt(i);
			if(isNum(ch)){
				//get int number after letter
				y = y * 10;
				int digit = ch - '0';
				y += digit;
			}else{
				throw new Exception("Invalid Cell Num '"+ word +"'");
			}
		}
		
		
	}
	private boolean isNum(char ch){
		int digit = ch - '0';
		if(digit <= 9 && digit >= 0) return true;
		return false;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		char col = (char)('A'+ x);
		String formatted = String.format("%s%d", col, y);
		return formatted;
	}
	public double getValue(){
		//calculated by Expression
		return Spreadsheet.dict.get(cellNum).getValue();
	}
	
	
}
