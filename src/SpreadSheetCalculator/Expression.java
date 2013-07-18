package SpreadSheetCalculator;

import java.util.ArrayList;
import java.util.Stack;

import SpreadSheetCalculator.Token.TokenType;

public class Expression {
	public enum VisitStatus {Unvisited, Visiting, Visited}
	private ArrayList<Token> tokenList = null;
	private String cellNum;
	public VisitStatus status = VisitStatus.Unvisited;
	private double value;
	public Expression(){
		
	}
	public Expression(String word, int origIndex) throws Exception{
		setTokenList(word);
		setCellNum(origIndex);
	}
	
	public void setCellNum(int indexInList){
		int col = indexInList/Spreadsheet.col;
		int row = indexInList%Spreadsheet.col;
		char ch = (char)('A' + col);
		StringBuffer sb = new StringBuffer();
		sb.append(ch);
		sb.append(row+1);
		cellNum = sb.toString();
	}
	public String getCellNum(){
		return cellNum;
	}
	public void setTokenList(String str) throws Exception{
		ArrayList<Token> list = new ArrayList<Token>();
		String[] words = str.split(" ");
		for(int i = 0; i < words.length; i++){
			Token token = Token.createNewToken(words[i]);
			list.add(token);
		}
		tokenList = list;
	} 
	public ArrayList<Token> getTokenList(){
		return tokenList;
	}
	
	public boolean containsCellNumToken(){
		for(Token token: tokenList){
			if(token.getTokenType() == token.tokenType.CELLNUM){
				return true;
			}
		}
		return false;
	}
	public ArrayList<Token> getConnectedCellNumToken(){
		ArrayList<Token> connectedToken = new ArrayList<Token>();
		for(Token token: tokenList){
			if(token.getTokenType() == token.tokenType.CELLNUM){
				connectedToken.add(token);
			}
		}
		return connectedToken;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(Token token: tokenList){
			String formatted = String.format("%s ", token.toString());
			sb.append(formatted);
		}
		return sb.toString();
	}
	
	
	public void calSetValue() throws Exception {
		
		Stack<Token> stack = new Stack<Token>();// change to float
		for (Token token : tokenList) {
			if (token.tokenType == TokenType.OPERATION) {
				if (stack.size() < 2) {
					throw new Exception("Expression <" + toString() + ">: Operand is missing");
				} else {
					Token a = stack.pop();
					Token b = stack.pop();
					double result = 0;
					result = token.calculate(b.getValue(),a.getValue());
					Token t = new NumToken(result);
					stack.push(t);
				}
			} else {
				stack.push(token);
			}
		}
		if (stack.empty()) {
			throw new Exception("Expression <" + toString() + ">:Empty expression");
		} else {
			if (stack.size() != 1) {
				throw new Exception("Expression <" + toString() + ">: operator is missing");
			}
		}
		value = stack.pop().getValue();
	}
	public double getValue(){
		return value;
	}
	public String getPrintValue(){
		String formatted = String.format("%.5f", value);
		return formatted;
	}
}