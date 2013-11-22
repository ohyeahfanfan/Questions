package SpreadSheetCalculator;

public abstract class Token {
	public enum TokenType{NUM, OPERATION, CELLNUM}
	protected TokenType tokenType;
	public int x;
	public int y;
	public String cellNum;
	public static Token createNewToken(String word) throws Exception{
		Token token = null;
		//Operation Token +/-/*//
		word = word.trim(); // remove leading space or extra space between
		if(OpToken.isValidToken(word)){
			token = OpToken.createOpToken(word);
			token.tokenType = TokenType.OPERATION;
		//A1 Cell
		}else if(CellNumToken.isValidToken(word)){
			token = new CellNumToken(word);
			token.tokenType = TokenType.CELLNUM;
		//0 number
		}else if(NumToken.isValidToken(word)){
			token = new NumToken(word);
			token.tokenType = TokenType.NUM;
		}else{
			throw new Exception("invalid token "+ word);
		}
		return token;
	}
	public TokenType getTokenType(){
		return tokenType;
	}
	public double calculate(double a, double b){
		return 0.0f;
	}
	public abstract double getValue();
}

